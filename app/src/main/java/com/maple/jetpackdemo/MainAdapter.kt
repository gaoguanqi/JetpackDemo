package com.maple.jetpackdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.maple.jetpackdemo.app.manager.listener.OnItemClickListener

/**
 * author: gaogq
 * time: 2019/4/8 17:10
 * description:
 */
class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var mData:MutableList<String>? = null
    var mListener: OnItemClickListener? = null

    fun setData(date: MutableList<String>){
        this.mData = date
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false))
    }

    override fun getItemCount(): Int {
        return if(mData == null) 0 else mData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.setData(position,mData?.get(position))
       if(mListener != null){
           holder.llRoot.setOnClickListener { mListener?.onItemClick(position,mData!!.get(position)) }
       }
    }

     class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val tvName : TextView = itemView.findViewById(R.id.tv_name)
        val llRoot : CardView = itemView.findViewById(R.id.item_root)

        fun setData(pos:Int,data:String?){
            tvName.setText(data)
        }
    }
}