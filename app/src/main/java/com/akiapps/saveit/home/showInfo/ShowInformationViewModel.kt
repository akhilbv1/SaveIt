package com.akiapps.saveit.home.showInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akiapps.frameworklib.AddInformationUseCase
import com.akiapps.frameworklib.GetInformationUseCase
import com.akiapps.frameworklib.InformationType
import com.akiapps.frameworklib.password.PasswordDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class ShowInformationViewModel @Inject constructor(private val getInformationUseCase: GetInformationUseCase) : ViewModel() {

    private val _passwordDetailsLiveData: MutableLiveData<List<InformationType>> = MutableLiveData()
    val passwordDetailsLiveData: LiveData<List<InformationType>>
    get() = _passwordDetailsLiveData

    init {
        getPasswordDetails()
    }

    private fun getPasswordDetails() {
       viewModelScope.launch {
           getInformationUseCase.getPasswordDetails().collect {
               _passwordDetailsLiveData.value = it
           }
       }
    }
}