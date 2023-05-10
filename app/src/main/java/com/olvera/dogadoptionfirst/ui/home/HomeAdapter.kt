package com.olvera.dogadoptionfirst.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.databinding.ItemDogBinding
import com.olvera.dogadoptionfirst.model.domain.Dog
import com.olvera.dogadoptionfirst.util.randomBackground

class HomeAdapter(
    private val dogList: List<Dog>,
    private val onDogClick: (Dog) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view
        holder.bind(dogList[position], onDogClick)
    }

    override fun getItemCount(): Int = dogList.size

    class HomeViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(dog: Dog, onDogClick: (Dog) -> Unit) {
            view.tvDogName.text = dog.dogName
            view.tvDogAge.text = dog.dogAge

            randomBackground(view.cardDog.background, true)

            Glide.with(view.root.context)
                .asBitmap()
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image_not_supported)
                .load(dog.imageUrl)
                .into(view.imageDog)
            view.root.setOnClickListener {
                onDogClick(dog)
            }
        }
    }


}