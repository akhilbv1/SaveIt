package com.akiapps.saveit.home.showInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.akiapps.frameworklib.InformationType
import com.akiapps.saveit.databinding.FragmentInfoListBinding
import com.akiapps.saveit.gone
import com.akiapps.saveit.home.showInfo.adapter.ShowInformationListAdapter
import com.akiapps.saveit.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowInformationListFragmnet : Fragment() {

    private lateinit var binding: FragmentInfoListBinding
    private val showInformationViewModel: ShowInformationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObservers()
    }

    private fun initUi() {
        binding.fabAddInfo.setOnClickListener {
            findNavController().navigate(ShowInformationListFragmnetDirections.actionShowInformationFragmentToAddInformationBottomSheet())
        }
    }

    private fun initObservers() {
        showInformationViewModel.passwordDetailsLiveData.observe(requireActivity()) {
            if (it.isNotEmpty()) {
                binding.textNoData.gone()
                setupDetailsRecyclerView(it)
            } else {
                binding.textNoData.visible()
            }
        }
    }

    private fun setupDetailsRecyclerView(list: List<InformationType>) {
        val showInfoAdapter = ShowInformationListAdapter(list)
        binding.recInfoList.apply {
            adapter = showInfoAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}