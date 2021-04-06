package com.destructo.mars.app.ui.marsImageList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _currentSol = MutableLiveData(0)
    val currentSol: LiveData<Int>
    get() = _currentSol

    fun getMarsImagesByRoverName(rover: String) =
        viewModelScope.launch{
            repository.getLatestMarsImagesByRover(rover, _currentSol.value.toString())
        }

    fun deleteAllImages() = repository.clearList()

    fun clearNextSol() = repository.clearNextPage()

    fun setCurrentMartianSol(sol: Int) {
        _currentSol.value = sol
    }


}