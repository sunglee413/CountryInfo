package com.slee.country.ui

import androidx.recyclerview.widget.RecyclerView
import com.slee.country.data.Country
import com.slee.country.databinding.CountryItemBinding

class CountryViewHolder(private val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country, onItemClicked: (Country) -> Unit) {
        with(binding) {
            title.text = country.name

            root.setOnClickListener {
                onItemClicked(country)
            }
        }

    }

}
