package com.akiapps.saveit

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import java.lang.ref.WeakReference

inline fun <reified T : ViewModel> ViewModelStoreOwner.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProvider(this, vmFactory).get(T::class.java)
}

fun Context.showToast(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

class FragmentEventsBackPressedCallback(
    fragment: Fragment,
    private val eventsCallback: () -> Unit,
) : OnBackPressedCallback(true) {
    private val fragmentReference = WeakReference(fragment)
    override fun handleOnBackPressed() {
        fragmentReference.get()?.findNavController()?.popBackStack()
        eventsCallback()
    }
}