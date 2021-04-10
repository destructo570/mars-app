package com.destructo.mars.app.ui.marsImageDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.destructo.mars.app.databinding.FragmentImageDetailBinding

class ImageDetailFragment : Fragment() {

    private var _binding: FragmentImageDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ImageDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        setBindingData()
        setupToolbar()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setBindingData(){
        binding.imgDetailRoverName.text = args.imageDetail.rover?.name
        binding.imgDetailCamera.text = args.imageDetail.camera?.name
        binding.imgDetailEarthDate.text = args.imageDetail.earthDate
        binding.imgDetailSol.text = args.imageDetail.sol.toString()
        binding.imgDetailImage.load(args.imageDetail.imgSrc)
    }

    private fun setupToolbar(){
        binding.toolbar.title = args.imageDetail.photoId.toString()
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }
}