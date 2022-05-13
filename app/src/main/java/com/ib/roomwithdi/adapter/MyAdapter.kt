package com.ib.roomwithdi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ib.roomwithdi.R
import com.ib.roomwithdi.data.User
import com.ib.roomwithdi.databinding.NameTemplateBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var listOfNames: List<User> = emptyList()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NameTemplateBinding.bind(view)
        fun bind(user: User) {
            binding.tvName.text = user.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.name_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(listOfNames[position])
    }

    override fun getItemCount(): Int {
        return listOfNames.size
    }

    fun setNames(user: List<User>) {
       this.listOfNames = user
        notifyDataSetChanged()
    }
}