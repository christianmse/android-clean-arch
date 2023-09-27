package com.iot.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.android.compat.ViewModelCompat
import kotlin.reflect.KClass

abstract class BaseActivity<BINDING: ViewBinding, VM: ViewModel>(
    private val viewModelClazz: KClass<VM>
): AppCompatActivity() {
    private var _binding: BINDING? = null
    protected val binding
        get() = requireNotNull(_binding) {
            "_binding is null for ${viewModelClazz.java.simpleName}"
        }

    protected val viewModel: VM by lazy {
        ViewModelCompat.getViewModel(
            owner = this,
            clazz = viewModelClazz.java
        )
    }

    protected abstract fun setUpViewBinding(inflater: LayoutInflater): BINDING
    protected open fun observeViewModel(mViewModel: VM) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = setUpViewBinding(layoutInflater)
        setContentView(binding.root)
    }
}