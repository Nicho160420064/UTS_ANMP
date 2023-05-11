package com.ubaya.uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_anmp.R
import com.ubaya.uts_anmp.model.Food
import com.ubaya.week4_160420064_c.util.loadImage

class FoodListAdapter(val foodList:ArrayList<Food>)
    : RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>(){
    class FoodViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.food_list_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtName).text = foodList[position].nama
        holder.view.findViewById<TextView>(R.id.txtJarak).text = foodList[position].jarak
        holder.view.findViewById<TextView>(R.id.txtReview).text = foodList[position].review + " Review"
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        imageView.loadImage(foodList[position].gambar)
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener{
            val action = FoodListFragmentDirections.actionFoodDetail(foodList[position].nama.toString(),foodList[position].jarak.toString(),foodList[position].review.toString(),foodList[position].gambar.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    fun updateFoodList(newFoodList: ArrayList<Food>) {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }
}