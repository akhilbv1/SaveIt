package com.akiapps.saveit.home.showInfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akiapps.frameworklib.InformationType
import com.akiapps.frameworklib.InformationType.PasswordType
import com.akiapps.saveit.R
import com.akiapps.saveit.databinding.ItemInformationPasswordBinding
import com.akiapps.saveit.home.showInfo.viewholder.PasswordDetailsViewHolder

private const val ITEM_TYPE_PASSWORD = 1
private const val ITEM_TYPE_INFORMATION = 2
private const val ITEM_TYPE_Card = 3
private const val INVALID_VIEW = -1

class ShowInformationListAdapter(private val infoList: List<InformationType>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return when(viewType) {
            ITEM_TYPE_PASSWORD -> {
                val passwordView = ItemInformationPasswordBinding.inflate(LayoutInflater.from(parent.context),parent,false)
              PasswordDetailsViewHolder(passwordView)
            }
           else -> {
               val passwordView = ItemInformationPasswordBinding.inflate(LayoutInflater.from(parent.context),parent,false)
               PasswordDetailsViewHolder(passwordView)
           }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PasswordDetailsViewHolder -> holder.updateUi(infoList[position] as PasswordType)
        }
    }

    override fun getItemViewType(position: Int): Int {
       return when(infoList[position]) {
            is PasswordType -> ITEM_TYPE_PASSWORD
        }
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

}