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

    var mContext: Context? =null
    lateinit var mContainerList:List<Container>
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var containerInfo:TextView
        var containerStatus:TextView

        init {
            containerInfo=view.container_name
            containerStatus=view.container_status

        }
    }
    init {
        mContainerList=container
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
        var container: Container = mContainerList.get(position)
        holder.containerInfo.text = container.name
        if (container.status == 0){
            holder.containerStatus.text = mContext?.resources?.getString(R.string.unknown)
        } else if(container.status==1) {
            holder.containerStatus.setTextColor(Color.RED)
            holder.containerStatus.text = mContext?.resources?.getString(R.string.stop)
        } else if(container.status==2) {
            holder.containerStatus.setTextColor(Color.parseColor("#ffffcc00"))
            holder.containerStatus.text = mContext?.resources?.getString(R.string.starting)
        } else if(container.status==3) {
            holder.containerStatus.setTextColor(Color.parseColor("#ffffcc00"))
            holder.containerStatus.text = mContext?.resources?.getString(R.string.stopping)
        }else if(container.status==4) {
            holder.containerStatus.setTextColor(Color.GREEN)
            holder.containerStatus.text = mContext?.resources?.getString(R.string.running)
        }
    }
}
