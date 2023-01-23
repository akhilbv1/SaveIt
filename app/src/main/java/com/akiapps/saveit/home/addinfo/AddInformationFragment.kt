package com.akiapps.saveit.home.addinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akiapps.frameworklib.generaldetails.GeneralDetails
import com.akiapps.frameworklib.password.PasswordDetailsEntity
import com.akiapps.saveit.FragmentEventsBackPressedCallback
import com.akiapps.saveit.databinding.LayoutAddInformationFragmentBinding
import com.akiapps.saveit.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddInformationFragment : Fragment() {

    private lateinit var binding: LayoutAddInformationFragmentBinding

    private val addInformationViewModel: AddInformationViewModel by viewModels()

    private var type: Int = INFO_TYPE_GENERAL

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
        type = arguments?.getInt("InfoType") ?: INFO_TYPE_GENERAL
        initViews()
        initObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home) requireActivity().onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun initViews() {
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        val backPressedCallback = FragmentEventsBackPressedCallback(this) {

        }
        requireActivity().onBackPressedDispatcher.addCallback(backPressedCallback)

        binding.textInputTextTile.hint = getTitleErrorTextByType()
        binding.textInputTextDes.hint = getDesErrorTextByType()

        binding.btnSaveInformation.setOnClickListener {
            if (isValidated()) {
                val title = binding.editTitle.text?.toString() ?: ""
                val des = binding.editDes.text?.toString() ?: ""
                if (type == INFO_TYPE_GENERAL) {
                    addInfo(title, des)
                } else if (type == INFO_TYPE_PASSWORD) {
                    addPasswordInfo(title, des)
                }
            }
        }
    }

    private fun isValidated(): Boolean {
        if (binding.editTitle.text?.toString()?.isBlank() != false) {
            binding.editTitle.error = getTitleErrorTextByType()
            return false
        } else {
            binding.editTitle.error = null
        }
        if (binding.editDes.text?.toString()?.isBlank() != false) {
            binding.editDes.error = getDesErrorTextByType()
            return false
        } else {
            binding.editDes.error = null
        }
        return true
    }

    private fun getTitleErrorTextByType(): String = if(type == INFO_TYPE_GENERAL) "Please enter title" else "Please enter Password Name"

    private fun getDesErrorTextByType(): String = if(type == INFO_TYPE_GENERAL) "Please enter Description" else "Please enter Password"

    private fun addPasswordInfo(title: String, password: String) {
        val details = PasswordDetailsEntity(passwordTitle = title, password = password)
        addInformationViewModel.addPasswordDetails(details)
    }

    private fun addInfo(title: String, des: String) {
        val genDetails = GeneralDetails(title = title, description = des)
        addInformationViewModel.addGeneralDetails(genDetails)
    }

    private fun initObservers() {
        addInformationViewModel.addInformationStatus.observe(requireActivity()) {
            binding.editTitle.text?.clear()
            binding.editDes.text?.clear()
            if(it) requireActivity().showToast("Added Successfully") else requireActivity().showToast("Adding Data Failed")
        }
    }

    companion object {
        const val INFO_TYPE_PASSWORD = 1
        const val INFO_TYPE_GENERAL = 2
    }
}