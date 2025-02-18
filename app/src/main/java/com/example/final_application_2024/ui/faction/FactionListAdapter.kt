package com.example.final_application_2024.ui.faction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.final_application_2024.data.Faction
import com.example.final_application_2024.databinding.FactionListContentBinding

class FactionListAdapter(
    private val toFactionEdit:(Int) -> Unit
):ListAdapter<Faction, FactionListAdapter.FactionViewHolder>(FactionDiffCallback) {
    inner class FactionViewHolder(
        private val binding: FactionListContentBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(faction: Faction){
            binding.factionName.text = faction.name
            binding.root.setOnClickListener {
                toFactionEdit(faction.id)
            }
        }
    }
    
    object FactionDiffCallback:DiffUtil.ItemCallback<Faction>() {
        override fun areItemsTheSame(oldItem: Faction, newItem: Faction): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Faction, newItem: Faction): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactionViewHolder {
        val binding: FactionListContentBinding = FactionListContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}