package com.destructo.mars.app.ui.marsImageList

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.destructo.mars.app.databinding.ImagesFilterBottomsheetBinding
import com.destructo.mars.app.util.ARG_MARTIAN_SOL
import com.destructo.mars.app.util.toEditable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.ClassCastException

class ImagesFilterBottomSheet: BottomSheetDialogFragment(){

    private var _binding: ImagesFilterBottomsheetBinding? = null
    private val binding get() = _binding!!
    private lateinit var martianSol: String
    private var imageFilterListener: ImageFilterListener? = null

    companion object{
        fun newInstance(sol: String): ImagesFilterBottomSheet{
            val imagesFilterBottomSheet = ImagesFilterBottomSheet()
            val bundle = Bundle()
            bundle.putString(ARG_MARTIAN_SOL, sol)
            imagesFilterBottomSheet.arguments = bundle
            return imagesFilterBottomSheet
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageFilterListener  = parentFragment as ImageFilterListener

        martianSol = arguments?.getString(ARG_MARTIAN_SOL, "0")!!

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ImagesFilterBottomsheetBinding.inflate(layoutInflater, container, false)

        binding.textMartianSol.text = SpannableStringBuilder(martianSol)

        binding.buttonIncSol.setOnClickListener {
            val sol = binding.textMartianSol.text.toString().toInt()
            if (binding.textMartianSol.text != null ){
                binding.textMartianSol.text = sol.plus(1).toString().toEditable()
            }
        }

        binding.buttonDecSol.setOnClickListener {
            val sol = binding.textMartianSol.text.toString().toInt()
            if (binding.textMartianSol.text != null ){
                binding.textMartianSol.text = sol.minus(1).toString().toEditable()
            }
        }

        binding.buttonApply.setOnClickListener {
            imageFilterListener?.onClick(binding.textMartianSol.text.toString())
            dismiss()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
           imageFilterListener =  parentFragment as ImageFilterListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement ImageFilterListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        imageFilterListener = null
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    interface ImageFilterListener {
        fun onClick(martianSol: String)
    }
}