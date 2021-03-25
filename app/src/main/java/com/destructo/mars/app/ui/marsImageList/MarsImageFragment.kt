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
import com.destructo.mars.app.util.GridSpacingItemDeco
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarsImageFragment : Fragment() {

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
            viewModel.getMarsImagesByRoverName(args.roverName)
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupToolbar()
        marsImageAdapter = MarsImageAdapter {}
        imageRecycler.adapter = marsImageAdapter

        viewModel.marsImages.observe(viewLifecycleOwner){ resource ->
            when(resource.status){
                Status.LOADING ->{
                    progressbar.visibility = View.VISIBLE
                }
                Status.SUCCESS ->{
                    progressbar.visibility = View.GONE
                    marsImageAdapter.submitList(resource.data?.photos)
                }
                Status.ERROR ->{
                    progressbar.visibility = View.GONE
                    Toast.makeText(context, "${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
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
}