package com.destructo.mars.app.ui.roverDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.destructo.mars.app.R
import com.destructo.mars.app.databinding.FragmentRoverDetailBinding
import com.destructo.mars.app.util.ARG_ROVER_NAME

class RoverDetailFragment : Fragment() {

    private var _binding: FragmentRoverDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var toolbar: Toolbar
    private val args: RoverDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoverDetailBinding.inflate(inflater, container, false)
        toolbar = binding.toolbar
        bindDataToViews()

        binding.buttonSeeImages.setOnClickListener {
            navigateToMarsImageFragment()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        toolbar.title = args.argRover.name
    }

    private fun bindDataToViews() {
        binding.roverDetailImage.setImageResource(args.argRover.image!!)
        binding.roverDetailName.text = args.argRover.name
        binding.roverDetailLandedOn.text = args.argRover.landingDate
        binding.roverDetailLaunchedOn.text = args.argRover.launchDate
        binding.roverDetailMainJob.text = args.argRover.mainJob
        binding.missionName.text = args.argRover.missionName
    }

    private fun navigateToMarsImageFragment(){
        findNavController().navigate(
            R.id.marsImageFragment,
            bundleOf(Pair(ARG_ROVER_NAME, args.argRover.name)
            ))
    }

}