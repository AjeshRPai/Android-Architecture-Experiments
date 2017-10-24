package com.example.ajeshpai.androidarchitecture

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MyRecyclerViewAdapter(private var list:ArrayList<MyPojo>?): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_mypojo,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textview.text=list?.get(position)?.name
    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }

    fun additems(list: ArrayList<MyPojo>){
        list.forEachIndexed { index, myPojo ->
            this.list?.add(myPojo)
            notifyItemInserted(itemCount-1)
        }
    }



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        internal var textview:TextView
        init {

            textview=itemView.findViewById(R.id.name)
        }

    }
}