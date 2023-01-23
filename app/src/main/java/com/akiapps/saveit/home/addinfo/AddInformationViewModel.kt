package com.akiapps.saveit.home.addinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.AddInformationUseCase
import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.frameworklib.password.PasswordDetailsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddInformationViewModel @Inject constructor(private val addInformationUseCase: AddInformationUseCase) : ViewModel() {

    private val _addInformationStatus: MutableLiveData<Boolean> = MutableLiveData()
    val addInformationStatus: LiveData<Boolean>
    get() = _addInformationStatus

    fun addGeneralDetails(generalDetails: GeneralDetails) {
        viewModelScope.launch {
           addInformationUseCase.addGeneralDetailsInfo(generalDetails)
        }
    }

    fun addPasswordDetails(passwordDetails: PasswordDetailsEntity) {
        viewModelScope.launch {
            addInformationUseCase.addPasswordInfo(passwordDetails).collect {
                _addInformationStatus.value = it != -1
            }
        }
    }

    fun addCardDetails(cardDetails: CardDetails) {
        viewModelScope.launch {
            addInformationUseCase.addCardDetailsInfo(cardDetails)
        }
    }
}