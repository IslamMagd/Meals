package com.example.mealz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Category
import com.example.mealz.databinding.CategoryItemBinding

class MealzAdapter: ListAdapter<Category,MealzAdapter.MealzViewHolder>(CategoryDiffCallback())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealzViewHolder {
        return MealzViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MealzViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    class MealzViewHolder(private val itemBinding: CategoryItemBinding): RecyclerView.ViewHolder(itemBinding.root)
    {
        fun bind(category: Category){
            itemBinding.apply {
                itemTvName.text = category.strCategory
                itemTvDesc.text = category.strCategoryDescription
                Glide.with(itemBinding.root.context).load(category.strCategoryThumb).into(itemBinding.itemIv)

            }
        }

    }
    class CategoryDiffCallback: DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category,
                                     newItem: Category
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(oldItem: Category,
                                        newItem: Category
        ): Boolean {
            return oldItem == newItem
        }


    }



}