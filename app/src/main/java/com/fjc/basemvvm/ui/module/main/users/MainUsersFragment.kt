package com.fjc.basemvvm.ui.module.main.users

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.fjc.basemvvm.R
import com.fjc.basemvvm.data.model.User
import com.fjc.basemvvm.databinding.FragmentMainUsersBinding
import com.fjc.basemvvm.ui.base.fragment.BaseViewModelFragment
import com.fjc.basemvvm.ui.module.main.users.adapter.MainUsersAdapter

class MainUsersFragment : BaseViewModelFragment<FragmentMainUsersBinding, MainUsersViewModel>() {

    private val adapter: MainUsersAdapter = MainUsersAdapter(context, this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        adapter.setViewModel(viewModel)
        viewModel.usersList.observe(this, Observer { t -> loadDataSuccess(t)  })
    }

    fun loadDataSuccess(list: List<User>?) {
        if (list != null) {
            adapter.setUsersList(list.toMutableList())
        }
    }

    companion object {

        fun newInstance() = MainUsersFragment().apply {
        }
    }

    override fun getViewModelClass(): Class<MainUsersViewModel> = MainUsersViewModel::class.java
    override fun getLayout(): Int = R.layout.fragment_main_users

}