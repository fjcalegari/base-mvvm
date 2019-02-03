package com.fjc.basemvvm.ui.module.main.users.adapter
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fjc.basemvvm.R
import com.fjc.basemvvm.data.model.User
import com.fjc.basemvvm.databinding.ItemMainUsersBinding
import com.fjc.basemvvm.ui.module.main.users.MainUsersViewModel

class MainUsersAdapter(private val context: Context?,
                       fragment: Fragment): RecyclerView.Adapter<MainUsersAdapter.ListViewHolder>() {

    private var list: MutableList<User> = mutableListOf()
    private lateinit var viewModel: MainUsersViewModel

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.user = list[position]
        holder.binding.viewModel = viewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_main_users, parent, false))
    }

    fun setViewModel(viewModel: MainUsersViewModel) {
        this.viewModel = viewModel
    }

    fun setUsersList(usersList: MutableList<User>) {
        this.list = usersList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(val binding: ItemMainUsersBinding) : RecyclerView.ViewHolder(binding.root)

}