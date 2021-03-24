package com.destructo.mars.app.ui.roverList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.destructo.mars.app.R
import com.destructo.mars.app.data.datasource.RoversList
import com.destructo.mars.app.databinding.FragmentRoverListBinding
import com.destructo.mars.app.util.LIST_ITEM_SPACING
import com.destructo.mars.app.util.ListItemVerticalDecor

class RoverListFragment : Fragment() {

    private var _binding: FragmentRoverListBinding? = null

    private val binding get() = _binding!!
    private lateinit var roverAdapter: RoverListAdapter
    private lateinit var roverRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentRoverListBinding.inflate(inflater, container, false)

        roverRecycler = binding.roverRecyclerView
        roverRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        roverRecycler.addItemDecoration(ListItemVerticalDecor(LIST_ITEM_SPACING))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        roverAdapter = RoverListAdapter {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
        }
        roverAdapter.submitList(RoversList.rovers)
        roverRecycler.adapter = roverAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}