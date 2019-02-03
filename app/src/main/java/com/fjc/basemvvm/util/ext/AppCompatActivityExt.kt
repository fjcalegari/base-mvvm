package com.fjc.basemvvm.util.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replaceFragmentInActivity(frameId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.transact {
        addToBackStack(null)
        replace(frameId, fragment, tag)
    }
}

fun AppCompatActivity.findFragmentByTag(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

fun AppCompatActivity.addFragmentToActivity(frameId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.transact {
        add(frameId, fragment, tag)
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}