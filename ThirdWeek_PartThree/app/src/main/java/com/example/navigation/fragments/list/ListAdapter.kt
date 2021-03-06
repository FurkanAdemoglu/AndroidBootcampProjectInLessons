package com.example.navigation.fragments.list

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navigation.R
import com.example.navigation.models.Pet

class ListAdapter:RecyclerView.Adapter<ListAdapter.ListViewHolder>( ) {
    private var list =ArrayList<Pet>()
    private var listener:IPetOnClickListener?=null
    class ListViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val nameTextView=view.findViewById<TextView>(R.id.nameTextView)
        val avatarImageView=view.findViewById<ImageView>(R.id.avatarImageView)
       val containerCardView=view.findViewById<CardView>(R.id.containerCardView)

        fun bind(pet: Pet,listener: IPetOnClickListener?){
            nameTextView.text=pet.name
           containerCardView.setOnClickListener { listener?.onClick(pet) }
            Glide.with(view.context).load(pet.imageUrl).into(avatarImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_row_pet,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val item=this.list[position]
        holder.bind(item,listener)
    }
    fun setPetsData(list:ArrayList<Pet>){
        this.list=list
        notifyDataSetChanged()
    }
    fun setPetOnClickListener(listener:IPetOnClickListener){
        this.listener=listener
    }

    override fun getItemCount(): Int =list.size


}