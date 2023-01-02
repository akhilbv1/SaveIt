package com.akiapps.saveit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akiapps.saveit.databinding.LayoutAddInformationFragmentBinding

class AddInformationFragment : Fragment() {

    private lateinit var binding: LayoutAddInformationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAddInformationFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}