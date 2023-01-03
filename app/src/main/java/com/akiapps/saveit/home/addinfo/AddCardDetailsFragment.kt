package com.akiapps.saveit.home.addinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.akiapps.frameworklib.card.CardDetails
import com.akiapps.saveit.R
import com.akiapps.saveit.databinding.FragmentAddCardDetailsBinding
import com.akiapps.saveit.databinding.LayoutAddInformationFragmentBinding
import com.akiapps.saveit.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class AddCardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAddCardDetailsBinding

    private val addInformationViewModel: AddInformationViewModel by viewModels()

    private var cardExpMonth = -1

    private var cardExpYear = -1

    private var cardType = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCardDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTextWatchers()
        initSpinners()
        initViews()
    }

    private fun initViews() {
        binding.btnSaveInformation.setOnClickListener {
            validateAndSaveCardDetails()
        }
    }

    private fun initTextWatchers() {
        binding.editCardNumber.addTextChangedListener {
            binding.itemCardDetails.textCardNumber.text = it.toString()
        }
        binding.editCardCvv.addTextChangedListener {
            binding.itemCardDetails.textCardCvv.text = it.toString()
        }
        binding.editCardName.addTextChangedListener {
            binding.itemCardDetails.textCardName.text = it.toString()
        }
    }

    private fun validateAndSaveCardDetails() {
        if (binding.editCardName.text.toString().isEmpty()) {
            requireContext().showToast(getString(R.string.enter_card_name))
        } else if (binding.editCardNumber.text.toString().isEmpty()) {
            requireContext().showToast(getString(R.string.enter_card_number))
        } else if (cardExpMonth == -1 || cardExpYear == -1) {
            requireContext().showToast(getString(R.string.select_month_year))
        } else if (binding.editCardCvv.text.toString().isEmpty()) {
            requireContext().showToast(getString(R.string.enter_card_cvv))
        } else if (cardType == -1) {
            requireContext().showToast(getString(R.string.select_card_type))
        } else {
            val cardDetails = CardDetails(
                cardType = cardType,
                cardNumber = binding.editCardNumber.text.toString(),
                cvv = binding.editCardCvv.text.toString(),
                expiry = "$cardExpMonth/$cardExpYear",
                cardCompany = null,
                cardName = binding.editCardName.text.toString()
            )
            addInformationViewModel.addCardDetails(cardDetails)
        }
    }

    private fun initSpinners() {
        val monthsArrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, getMonthsList())
        binding.spinnerMonth.adapter = monthsArrayAdapter

        val yearsArrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, getYearsList())
        binding.spinnerYear.adapter = yearsArrayAdapter

        val cardTypeArrayAdapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1,
            getCardTypesList()
        )
        binding.spinnerCardType.adapter = cardTypeArrayAdapter

        binding.spinnerCardType.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    binding.itemCardDetails.textCardType.text = getCardTypesList()[p2]
                    cardType = p2 + 1
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        binding.spinnerMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val year = if (cardExpYear == -1) "_" else cardExpYear
                cardExpMonth = getMonthsList()[p2].toInt()
                val expiryDetails = "$cardExpMonth/$year"
                binding.itemCardDetails.textCardExpiry.text = expiryDetails
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val month = if (cardExpMonth == -1) "_" else cardExpMonth
                cardExpYear = getYearsList()[p2].toInt()
                val expiryDetails = "$month/$cardExpYear"
                binding.itemCardDetails.textCardExpiry.text = expiryDetails
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun getCardTypesList(): List<String> {
        return listOf(getString(R.string.card_type_credit), getString(R.string.card_type_debit))
    }

    private fun getYearsList(): List<String> {
        val yearsList: ArrayList<String> = arrayListOf()
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        for (i in currentYear..currentYear + 30) {
            yearsList.add(i.toString())
        }
        return yearsList
    }

    private fun getMonthsList(): List<String> {
        val monthsList: ArrayList<String> = arrayListOf()
        for (i in 1..12) {
            monthsList.add(i.toString())
        }
        return monthsList
    }

}