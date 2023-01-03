package com.akiapps.saveit.home.addinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.AddInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddInformationViewModel @Inject constructor(private val addInformationUseCase: AddInformationUseCase) : ViewModel() {

    fun addGeneralDetails(generalDetails: GeneralDetails) {
        viewModelScope.launch {
            addInformationUseCase.addGeneralDetailsInfo(generalDetails)
        }
    }
}