package com.akiapps.saveit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akiapps.data.InfoType
import kotlinx.coroutines.launch

class AddInformationViewModel : ViewModel() {
    private val _addInfoLivedata: MutableLiveData<InfoType> = MutableLiveData()
    val addInfoLiveData: LiveData<InfoType>
    get() = _addInfoLivedata

    fun addInfo(infoType: InfoType){
        viewModelScope.launch {

        }
    }
}