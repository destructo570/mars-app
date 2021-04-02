package com.destructo.mars.app.ui.marsImageList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.destructo.mars.app.data.datasource.MarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsImageViewModel @Inject constructor(
    private val repository: MarsRepository
): ViewModel(){

    val allMarsImages = repository.getAllImages

    val marsImages = repository.marsImageList

    fun getMarsImagesByRoverName(rover: String) =
        viewModelScope.launch{ repository.getLatestMarsImagesByRover(rover) }

    fun deleteAllImages() = repository.clearList()

}