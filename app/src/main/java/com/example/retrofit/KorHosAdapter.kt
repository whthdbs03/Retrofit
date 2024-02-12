package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemBinding

class KorHosAdapter : ListAdapter<Row, KorHosAdapter.KorHosViewHolder>(KorHosCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KorHosViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KorHosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KorHosViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class KorHosViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Row) {
            with(binding) {
                tvName.text = item.mEDCAREINSTNM
                tvCity.text = item.sIGUNNM
                tvAddress.text = item.rEFINEROADNMADDR
                tvType.text = item.dISTRCTDIVNM
                tvNumber.text = item.eMGNCYCENTERTELNO
            }
        }
    }
    companion object {
        private val KorHosCallback =object : DiffUtil.ItemCallback<Row>() {
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }

        }
    }
}