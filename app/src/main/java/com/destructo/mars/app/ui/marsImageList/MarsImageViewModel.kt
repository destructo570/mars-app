package com.destructo.mars.app.ui.marsImageList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.destructo.mars.app.data.datasource.MarsRepository
import com.destructo.mars.app.data.model.latestPhoto.MarsImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsImageViewModel @Inject constructor(
    private val repository: MarsRepository
): ViewModel(){

    val marsImages = repository.marsImage

    fun getMarsImagesByRoverName(rover: String) =
        viewModelScope.launch{ repository.getLatestMarsImagesByRover(rover) }


}