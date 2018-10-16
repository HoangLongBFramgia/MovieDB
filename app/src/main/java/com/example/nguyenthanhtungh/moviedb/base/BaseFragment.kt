package com.example.nguyenthanhtungh.moviedb.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.nguyenthanhtungh.moviedb.R

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {
    abstract val bindingVariable: Int
    lateinit var viewBinding: ViewBinding
    abstract val viewModel: ViewModel
    abstract val layoutId: Int

    abstract fun initComponent(viewDataBinding: ViewBinding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding.apply {
            root.isClickable = true
            initComponent(viewBinding)
            setVariable(bindingVariable, viewModel)
            setLifecycleOwner(this@BaseFragment)
            executePendingBindings()
        }
        return viewBinding.root
    }


    fun findFragment(TAG: String): Fragment? {
        return activity?.supportFragmentManager?.findFragmentByTag(TAG)
    }

    fun findChildFragment(parentFragment: Fragment = this, TAG: String): Fragment? {
        return parentFragment.childFragmentManager.findFragmentByTag(TAG)
    }

    fun replaceFragment(fragment: Fragment, TAG: String?, addToBackStack: Boolean = false) {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment, TAG)?.apply {
                    commitTransaction(this, addToBackStack)
                }?.commit()
    }

    fun replaceChildFragment(parentFragment: Fragment = this, containerViewId: Int,
                             fragment: Fragment, TAG: String?, addToBackStack: Boolean = false) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
                containerViewId, fragment, TAG)
        commitTransaction(transaction, addToBackStack)
    }

    fun addChildFragment(parentFragment: Fragment = this, containerViewId: Int,
                         targetFragment: Fragment, TAG: String?, addToBackStack: Boolean = false) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().add(
                containerViewId, targetFragment, TAG)
        commitTransaction(transaction, addToBackStack)
    }

    private fun commitTransaction(transaction: FragmentTransaction, addToBackStack: Boolean = false) {
        if (addToBackStack) transaction.addToBackStack(null)
        transaction.commit()
    }

    fun popChildFragment(parentFragment: Fragment = this) {
        parentFragment.childFragmentManager.popBackStack()
    }

    open fun onBack(): Boolean {
        return false
    }
}
