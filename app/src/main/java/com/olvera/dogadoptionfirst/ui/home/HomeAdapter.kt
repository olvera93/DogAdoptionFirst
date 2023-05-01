package com.olvera.dogadoptionfirst.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.databinding.ItemDogBinding
import com.olvera.dogadoptionfirst.model.domain.Dog

class HomeAdapter(
    private val dogList: List<Dog>
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount(): Int = dogList.size

    class HomeViewHolder(var view: ItemDogBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(dog: Dog) {
            view.tvDogName.text = dog.name
            Glide.with(view.root.context)
                .load(dog.imageUrl)
                .into(view.imageDog)
        }
    }




}