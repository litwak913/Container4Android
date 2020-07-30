package io.github.litwak913.linuxstarter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        refresh.setColorSchemeResources(R.color.colorPrimary)
        container_list.layoutManager = LinearLayoutManager(activity)
        container_list.adapter = ContainerAdapter(genList())
        val actionBar: ActionBar? = (activity as AppCompatActivity).supportActionBar
        refresh.setOnRefreshListener {
            refresh.isRefreshing = false
        }
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


    }

    private fun genList(): List<Container> {
        val container: MutableList<Container> = ArrayList<Container>()
        for (i in 0..5) {
            container.add(Container("AAA", 0))
            container.add(Container("BBB", 1))
            container.add(Container("CCC", 2))
            container.add(Container("DDD", 3))
            container.add(Container("EEE", 4))

        }
        return container
    }


}
