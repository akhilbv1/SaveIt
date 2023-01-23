package com.akiapps.saveit.home.showInfo

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.akiapps.saveit.R
import com.akiapps.saveit.databinding.BottomSheetAddInfoBinding
import com.akiapps.saveit.home.addinfo.AddInformationFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddInformationBottomSheetBehaviour: BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetAddInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.AppBottomSheetDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BottomSheetAddInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHeight()
        setupUi()
    }

    private fun setupHeight() {
        binding.coordinator.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
    }

    private fun setupUi(){
        //Password Option
        binding.itemOptionAddPassword.textBottomSheetAddOption.text = "Add Password"
        binding.itemOptionAddGeneralDetails.textBottomSheetAddOption.text = "Add General Details"
        binding.itemOptionAddCardDetails.textBottomSheetAddOption.text = "Add Card Details"

        binding.itemOptionAddPassword.optionItem.setOnClickListener {
            findNavController().navigate(AddInformationBottomSheetBehaviourDirections.actionAddInformationBottomSheetToAddInfomationFragment(AddInformationFragment.INFO_TYPE_PASSWORD))
        }
        binding.itemOptionAddGeneralDetails.optionItem.setOnClickListener {
            findNavController().navigate(AddInformationBottomSheetBehaviourDirections.actionAddInformationBottomSheetToAddInfomationFragment(AddInformationFragment.INFO_TYPE_GENERAL))
        }
        binding.itemOptionAddCardDetails.optionItem.setOnClickListener {
            findNavController().navigate(AddInformationBottomSheetBehaviourDirections.actionAddInformationBottomSheetToAddCardDetailsFragment())
        }
    }

}