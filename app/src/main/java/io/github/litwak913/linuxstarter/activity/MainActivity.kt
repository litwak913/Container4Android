package io.github.litwak913.linuxstarter.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import io.github.litwak913.linuxstarter.R
import io.github.litwak913.linuxstarter.fragment.AppSettingsFragment
import io.github.litwak913.linuxstarter.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var currentFragment: Fragment =
        MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.main_fragment, currentFragment)
                .commit()
        }
        nav_view.setCheckedItem(R.id.nav_home)
        nav_view.setNavigationItemSelectedListener {
            val item = it.itemId
            if (item == R.id.nav_setting) {
                switchFragment(AppSettingsFragment())
            } else if (item == R.id.nav_home) {
                switchFragment(MainFragment())
            }
            drawer_layout.closeDrawers()
            return@setNavigationItemSelectedListener true
        }
        setSupportActionBar(tool_bar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawers()
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawers()
        } else
            super.onBackPressed()
    }

    private fun switchFragment(targetFragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
        if (!targetFragment.isAdded) {
            transaction
                .hide(currentFragment)
                .add(R.id.main_fragment, targetFragment)
                .commit()
        } else {
            transaction
                .hide(currentFragment)
                .show(targetFragment)
                .commit()
        }
        currentFragment = targetFragment
    }
}