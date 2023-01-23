package com.akiapps.saveit.home.showInfo.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.akiapps.frameworklib.InformationType
import com.akiapps.frameworklib.password.PasswordDetails
import com.akiapps.saveit.databinding.ItemInformationPasswordBinding

class PasswordDetailsViewHolder(private val binding: ItemInformationPasswordBinding): RecyclerView.ViewHolder(binding.root) {

    fun updateUi(item: InformationType.PasswordType) {
        binding.textTitleInfo.text = item.passwordDetails.passwordTitle
        binding.textDesInfo.text = item.passwordDetails.password
    }
}