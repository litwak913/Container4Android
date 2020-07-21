package io.github.litwak913.linuxstarter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tool_bar)
        container_list.layoutManager=LinearLayoutManager(this)
        container_list.adapter=ContainerAdapter(genList())
        var actionBar: ActionBar? = supportActionBar

            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
        nav_view.setCheckedItem(R.id.nav_home)
        nav_view.setNavigationItemSelectedListener {
            drawer_layout.closeDrawers()
            return@setNavigationItemSelectedListener true
        }

    }
    fun genList():List<Container> {
        var container:MutableList<Container> =ArrayList<Container>()
        for(i in 0..5) {
            container.add(Container("AAA", 0))
            container.add(Container("BBB", 1))
            container.add(Container("CCC", 2))
            container.add(Container("DDD", 3))
            container.add(Container("EEE", 4))

        }
        return container
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            drawer_layout.openDrawer(GravityCompat.START)
        }
        return true
    }
}