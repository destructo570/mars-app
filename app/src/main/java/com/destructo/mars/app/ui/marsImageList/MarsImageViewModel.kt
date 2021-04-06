package com.destructo.mars.app.ui.marsImageList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.destructo.mars.app.data.datasource.MarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsImageViewModel @Inject constructor(
    private val repository: MarsRepository
): ViewModel(){

    val allMarsImages = repository.getAllImages

    val marsImages = repository.marsImageList

    private val _currentSol = MutableLiveData<Int>()
    val currentSol: LiveData<Int>
    get() = _currentSol

    init {
        deleteAllImages()
        setCurrentMartianSol(0)
    }

    fun getMarsImagesByRoverName(rover: String) =
        viewModelScope.launch(Dispatchers.IO){
            repository.getLatestMarsImagesByRover(rover, _currentSol.value.toString())
        }

    fun deleteAllImages() = repository.clearList()

    fun clearNextSol() = repository.clearNextPage()

    fun setCurrentMartianSol(sol: Int) {
        _currentSol.value = sol
    }


}