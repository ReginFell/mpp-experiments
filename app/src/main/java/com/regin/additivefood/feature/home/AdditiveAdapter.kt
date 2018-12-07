package com.regin.additivefood.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.regin.additivefood.R
import com.regin.additivefood.db.model.Additive
import kotlinx.android.synthetic.main.item_additive.view.*

class AdditiveAdapter : ListAdapter<Additive, AdditiveAdapter.ViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_additive, parent, false)

        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(additive: Additive) {
            itemView.name.text = additive.name
        }
    }

    private object ItemCallback : DiffUtil.ItemCallback<Additive>() {
        override fun areItemsTheSame(oldItem: Additive, newItem: Additive): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Additive, newItem: Additive): Boolean {
            return oldItem == newItem
        }
    }
}