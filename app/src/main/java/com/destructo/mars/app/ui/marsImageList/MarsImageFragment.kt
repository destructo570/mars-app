package com.destructo.mars.app.ui.marsImageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.destructo.mars.app.data.datasource.Status
import com.destructo.mars.app.databinding.FragmentMarsImageBinding
import com.destructo.mars.app.listener.ListEndListener
import com.destructo.mars.app.util.GridSpacingItemDeco
import com.destructo.mars.app.util.hide
import com.destructo.mars.app.util.show
import dagger.hilt.android.AndroidEntryPoint
import com.destructo.mars.app.ui.marsImageList.ImagesFilterBottomSheet as ImagesFilterBottomSheet1

@AndroidEntryPoint
class MarsImageFragment : Fragment(), ImagesFilterBottomSheet1.ImageFilterListener {

    private var _binding: FragmentMarsImageBinding? = null
    private val binding get() = _binding!!
    private val args: MarsImageFragmentArgs by navArgs()
    private val viewModel: MarsImageViewModel by viewModels()
    private lateinit var marsImageAdapter: MarsImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsImageBinding.inflate(inflater, container, false)

        binding.marsImageRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(GridSpacingItemDeco(2, 25, true))
        }

        binding.fabFilter.setOnClickListener {
            ImagesFilterBottomSheet1.newInstance(viewModel.currentSol.value.toString())
                .show(childFragmentManager, "filter_bottom_sheet")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setupToolbar()
        marsImageAdapter = MarsImageAdapter {}
        marsImageAdapter.setListEndListener(object : ListEndListener{
            override fun onEndReached(position: Int) {
                viewModel.getMarsImagesByRoverName(args.roverName)
            }
        })

        binding.marsImageRecycler.adapter = marsImageAdapter

        viewModel.marsImages.observe(viewLifecycleOwner){ resource ->
            when(resource.status){
                Status.LOADING ->{
                    binding.progressbar.show()
                }
                Status.SUCCESS ->{
                    binding.progressbar.hide()
                }
                Status.ERROR ->{
                    binding.progressbar.hide()
                    Toast.makeText(context, "${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.currentSol.observe(viewLifecycleOwner){
            viewModel.getMarsImagesByRoverName(args.roverName)
        }

        viewModel.allMarsImages.observe(viewLifecycleOwner){
            marsImageAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        binding.marsImageRecycler.adapter = null
        _binding = null
        super.onDestroyView()
    }

    private fun setupToolbar(){
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    override fun onClick(martianSol: String) {
        viewModel.deleteAllImages()
        viewModel.clearNextSol()
        viewModel.setCurrentMartianSol(martianSol.toInt())
    }

}