package com.example.recyclerview

import android.accounts.AuthenticatorDescription
import android.animation.LayoutTransition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
//class FoodsAdapter:RecyclerView.Adapter <FoodsAdapter.FoodsViewHolder>(private var foodList:ArrayList<Item>)
class FoodsAdapter:RecyclerView.Adapter <FoodsAdapter.FoodsViewHolder>(){

    private var foodList=ArrayList<Item>()
    private var listener:IFoodOnClick?=null

    class FoodsViewHolder(var view: View):RecyclerView.ViewHolder(view){
        val nameTextView:TextView=view.findViewById(R.id.nameTextView)
        val descriptionTextView:TextView=view.findViewById(R.id.descriptionTextView)
        val containerCardView:CardView=view.findViewById(R.id.containerCardView)

        fun setItem(item: Item,listener:IFoodOnClick?){
            nameTextView.text=item.name
            descriptionTextView.text=item.description
            containerCardView.setOnClickListener {
              listener?.onClick(item)

            }
        }
        /*fun setBind(item:String){
          //  view.findViewById<TextView>(R.id.recyclerView)
        }*/
    }

    fun setFoodList(foodList:ArrayList<Item>){
        this.foodList=foodList
        notifyDataSetChanged()
    }
    fun addFood(item:Item){
        this.foodList.add(item)
        notifyItemInserted(0)
    }

    fun addListener(listener: IFoodOnClick?){
        this.listener=listener
    }

    fun removeListeners() {
        this.listener=null
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodsAdapter.FoodsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)
        return FoodsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodsAdapter.FoodsViewHolder, position: Int) {
        val item=foodList[position]
        holder.setItem(item,listener)
    }

    override fun getItemCount(): Int {//veya Int=foodList.size
        return foodList.size
    }



}