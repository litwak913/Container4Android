package io.github.litwak913.linuxstarter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.linux_container_item.view.*

class ContainerAdapter(container:List<Container>):RecyclerView.Adapter<ContainerAdapter.ViewHolder>(){

    private var mContext: Context? =null
    private var mContainerList:List<Container> = container

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var containerInfo:TextView = view.container_name
        var containerStatus:TextView = view.container_status

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext==null){
            mContext=parent.context
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.linux_container_item,parent,false))
    }

    override fun getItemCount(): Int {
        return mContainerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val container: Container = mContainerList.get(position)
        holder.containerInfo.text = container.name
        when (container.status) {
            0 -> {
                holder.containerStatus.setTextColor(Color.BLACK)
                holder.containerStatus.text = mContext?.resources?.getString(R.string.unknown)
            }
            1 -> {
                holder.containerStatus.setTextColor(Color.RED)
                holder.containerStatus.text = mContext?.resources?.getString(R.string.stop)
            }
            2 -> {
                holder.containerStatus.setTextColor(Color.parseColor("#ffffcc00"))
                holder.containerStatus.text = mContext?.resources?.getString(R.string.starting)
            }
            3 -> {
                holder.containerStatus.setTextColor(Color.parseColor("#ffffcc00"))
                holder.containerStatus.text = mContext?.resources?.getString(R.string.stopping)
            }
            4 -> {
                holder.containerStatus.setTextColor(Color.GREEN)
                holder.containerStatus.text = mContext?.resources?.getString(R.string.running)
            }
        }
    }
}
