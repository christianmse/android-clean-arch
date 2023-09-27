package com.iot.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.android.compat.ViewModelCompat.getViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<BINDING: ViewBinding, VM: ViewModel>(
    private val viewModelClazz: KClass<VM>
): Fragment() {
    private var _binding: BINDING? = null
    protected val binding
        get() = requireNotNull(_binding) {
            "_binding is null for ${viewModelClazz.java.simpleName}"
        }

    protected val viewModel: VM by lazy { getViewModel(owner = this, clazz = viewModelClazz.java) }

    protected abstract fun setUpViewBinding(inflater: LayoutInflater, container: ViewGroup?): BINDING
    protected open fun observeViewModel(mViewModel: VM) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = setUpViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}