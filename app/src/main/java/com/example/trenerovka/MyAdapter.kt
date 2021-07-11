package com.example.trenerovka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var selectedItemPosition: Int = -1
        set(value) {
            if (field != -1) {
                models[field].isSelected = false
                notifyItemChanged(field)
            }
             field = value
             models[field].isSelected = true
             notifyItemChanged(field)
        }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(user: User,position: Int) {
            itemView.tvNumber.text = user.number.toString()
            itemView.bg.isVisible = user.isSelected
            itemView.setOnClickListener {
               selectedItemPosition = position
            }
        }
    }

    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(models[position],position)
    }

    override fun getItemCount() = models.size
}