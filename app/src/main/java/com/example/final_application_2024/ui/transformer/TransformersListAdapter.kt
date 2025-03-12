package com.example.final_application_2024.ui.transformer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.databinding.TransformersListContentBinding

class TransformersListAdapter(
    private val toTransformerEdit:(Int) -> Unit
):ListAdapter<
        Transformer,
        TransformersListAdapter.TransformersViewHolder
        >(TransformersDiffCallback) {
    inner class TransformersViewHolder(
        private val binding:TransformersListContentBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(transformer: Transformer){
            binding.transformerName.text = transformer.name
            binding.alternateMode.text = transformer.alternateMode
            binding.gender.text = transformer.gender
            binding.root.setOnClickListener {
                toTransformerEdit(transformer.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransformersViewHolder {
        val binding:TransformersListContentBinding = TransformersListContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransformersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransformersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TransformersDiffCallback:DiffUtil.ItemCallback<Transformer>() {
        override fun areItemsTheSame(oldItem: Transformer, newItem: Transformer) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Transformer, newItem: Transformer) = oldItem.name == newItem.name
    }
}