package com.akiapps.saveit.home.addinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.saveit.databinding.LayoutAddInformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddInformationFragment : Fragment() {

    private lateinit var binding: LayoutAddInformationFragmentBinding

    private val addInformationViewModel: AddInformationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAddInformationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.btnSaveInformation.setOnClickListener {
            if (isValidated()) {
                val title = binding.editTitle.text?.toString() ?: ""
                val des = binding.editDes.text?.toString() ?: ""
                addInfo(title, des)
            }
        }
    }

    private fun isValidated(): Boolean {
        if (binding.editTitle.text?.toString()?.isBlank() != false) {
            binding.editTitle.error = "Please enter title"
            return false
        } else {
            binding.editTitle.error = null
        }
        if (binding.editDes.text?.toString()?.isBlank() != false) {
            binding.editDes.error = "Please enter Description"
            return false
        } else {
            binding.editDes.error = null
        }
        return true
    }

    private fun addInfo(title: String,des: String) {
        val genDetails = GeneralDetails(title = title, description = des)
        addInformationViewModel.addGeneralDetails(genDetails)
    }
}