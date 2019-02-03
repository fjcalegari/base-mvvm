package com.fjc.basemvvm.ui.module.main.users

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import com.fjc.basemvvm.data.model.User
import com.fjc.basemvvm.data.repository.UsersRepository
import com.fjc.basemvvm.ui.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainUsersViewModel @Inject constructor(
    private val usersRepository: UsersRepository
) : BaseViewModel() {

    val usersList = MutableLiveData<List<User>>()

    init {
        addDisposable(
            usersRepository.getUsersList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onUsersListLoaded, this::onUsersListError)
        )
    }

    private fun onUsersListLoaded(usr: List<User>){
        usr.forEach {
            Log.d("MainUsersViewModel", "User: $it")
        }
        usersList.value = usr
    }

    fun onClickUser(user: User){
        Log.d("MainUsersViewModel", "onClickUser: $user")
    }

    private fun onUsersListError(throwable: Throwable){
        Log.e("MainUsersViewModel", "onUsersListError", throwable)
    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        Log.d("MainUsersViewModel", "onFirsTimeUiCreate")
    }

}