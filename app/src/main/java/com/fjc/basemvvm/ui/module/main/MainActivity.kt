package com.fjc.basemvvm.ui.module.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import com.fjc.basemvvm.R
import com.fjc.basemvvm.R.layout.activity_main
import com.fjc.basemvvm.databinding.ActivityMainBinding
import com.fjc.basemvvm.ui.base.activity.BaseViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseViewModelActivity<ActivityMainBinding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        fab.setOnClickListener {
            viewModel.onClickFab()
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        viewModel.countFab.observe(this, Observer {
            binding.content.count.text = it.toString()
        })

    }

    override fun getLayout(): Int = activity_main

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
