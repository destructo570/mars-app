package com.destructo.mars.app.ui.marsImageList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.destructo.mars.app.data.datasource.Status
import com.destructo.mars.app.databinding.FragmentMarsImageBinding
import com.destructo.mars.app.listener.ListEndListener
import com.destructo.mars.app.util.GridSpacingItemDeco
import dagger.hilt.android.AndroidEntryPoint
import com.destructo.mars.app.ui.marsImageList.ImagesFilterBottomSheet as ImagesFilterBottomSheet1

@AndroidEntryPoint
class MarsImageFragment : Fragment(), ImagesFilterBottomSheet1.ImageFilterListener {

    private var _binding: FragmentMarsImageBinding? = null
    private val binding get() = _binding!!
    private val args: MarsImageFragmentArgs by navArgs()
    private val viewModel: MarsImageViewModel by viewModels()
    private lateinit var imageRecycler: RecyclerView
    private lateinit var marsImageAdapter: MarsImageAdapter
    private lateinit var toolbar: Toolbar
    private lateinit var progressbar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            viewModel.deleteAllImages()
            viewModel.setCurrentMartianSol(0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsImageBinding.inflate(inflater, container, false)

        toolbar = binding.toolbar
        progressbar = binding.progressbar
        imageRecycler = binding.marsImageRecycler
        imageRecycler.layoutManager = GridLayoutManager(context, 2)
        imageRecycler.addItemDecoration(GridSpacingItemDeco(2, 25, true))

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

        imageRecycler.adapter = marsImageAdapter

        viewModel.marsImages.observe(viewLifecycleOwner){ resource ->
            when(resource.status){
                Status.LOADING ->{
                    progressbar.visibility = View.VISIBLE
                }
                Status.SUCCESS ->{
                    progressbar.visibility = View.GONE
                }
                Status.ERROR ->{
                    progressbar.visibility = View.GONE
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
        super.onDestroyView()
        imageRecycler.adapter = null
        _binding = null
    }

    private fun setupToolbar(){
        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    override fun onClick(martianSol: String) {
        viewModel.deleteAllImages()
        viewModel.clearNextSol()
        viewModel.setCurrentMartianSol(martianSol.toInt())
    }

}