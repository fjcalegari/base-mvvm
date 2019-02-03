package com.fjc.basemvvm.ui.module.main

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.util.SparseArray
import android.view.Menu
import android.view.MenuItem
import com.fjc.basemvvm.R
import com.fjc.basemvvm.R.layout.activity_main
import com.fjc.basemvvm.databinding.ActivityMainBinding
import com.fjc.basemvvm.ui.base.activity.BaseViewModelActivity
import com.fjc.basemvvm.ui.module.main.albums.MainAlbumsFragment
import com.fjc.basemvvm.ui.module.main.posts.MainPostsFragment
import com.fjc.basemvvm.ui.module.main.users.MainUsersFragment
import com.fjc.basemvvm.util.ext.findFragmentByTag
import com.fjc.basemvvm.util.ext.replaceFragmentInActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseViewModelActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var navAdapter: NavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "onCreate")

        if (savedInstanceState == null) {
            setSupportActionBar(binding.toolbar)

            navAdapter = NavAdapter()

            navigation.setOnNavigationItemSelectedListener(bottomNavigationSelectedListener)

            loadFragment(PAGE_USERS)
        }
    }

    private val bottomNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        loadFragment(getPositionForItemId(item.itemId))
        true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun getLayout(): Int = activity_main

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(position: Int) {
        val fragment = navAdapter.getFragment(position)
        if (fragment != null) {
            replaceFragmentInActivity(R.id.contentFrame, fragment, getTagForPosition(position))
        }
    }

    private fun getPositionForItemId(@IdRes itemId: Int): Int {
        return when (itemId) {
            R.id.nav_main_users -> PAGE_USERS
            R.id.nav_main_posts -> PAGE_POSTS
            R.id.nav_main_albums -> PAGE_ALBUMS
            else -> PAGE_USERS
        }
    }

    private fun getTagForPosition(position: Int): String {
        return when (position) {
            PAGE_USERS -> TAG_USERS
            PAGE_POSTS -> TAG_POSTS
            PAGE_ALBUMS -> TAG_ALBUMS
            else -> TAG_USERS
        }
    }

    private fun isValidPosition(position: Int): Boolean {
        return position in 0..(NUM_PAGES - 1)
    }

    private inner class NavAdapter {

        private val mFragments = SparseArray<Fragment>(NUM_PAGES)

        private fun createFragment(position: Int): Fragment? {
            val fragment: Fragment = when (position) {
                PAGE_USERS -> MainUsersFragment.newInstance()
                PAGE_POSTS -> MainPostsFragment.newInstance()
                PAGE_ALBUMS -> MainAlbumsFragment.newInstance()
                else -> return null
            }

            mFragments.put(position, fragment)
            return fragment
        }

        internal fun getFragment(position: Int): Fragment? {
            if (isValidPosition(position) && mFragments.get(position) != null) {
                return mFragments.get(position)
            }

            val fragment = findFragmentByTag(getTagForPosition(position))
            if (fragment != null) {
                mFragments.put(position, fragment)
                return fragment
            } else {
                return createFragment(position)
            }
        }
    }

    companion object {
        private const val NUM_PAGES = 3

        internal const val PAGE_USERS = 0
        internal const val PAGE_POSTS = 1
        internal const val PAGE_ALBUMS = 2

        private const val TAG_USERS = "tag-users"
        private const val TAG_POSTS = "tag-posts"
        private const val TAG_ALBUMS = "tag-albums"
    }

}
