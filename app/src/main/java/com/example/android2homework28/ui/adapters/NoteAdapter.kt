package com.example.android2homework28.ui.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android2homework28.data.models.NoteModels
import com.example.android2homework28.databinding.ItemNoteBinding
import com.example.android2homework28.interfaces.OnClickItem

@Suppress("UNUSED_EXPRESSION")
class NoteAdapter(private val onLongClick: OnClickItem, private val onClick: OnClickItem): ListAdapter<NoteModels, NoteAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteModels) {
            binding.itemTitle.text = item.title
            binding.itemDescription.text = item.description
            binding.mcPan.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor(item.color)))
            binding.tvDataTime.text = item.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnLongClickListener {
            onLongClick.onLongClick(getItem(position))
            true
        }

        holder.itemView.setOnClickListener {
            onClick.onClick(getItem(position))
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NoteModels>() {
        override fun areItemsTheSame(oldItem: NoteModels, newItem: NoteModels): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NoteModels, newItem: NoteModels): Boolean {
            return oldItem.id == newItem.id
        }
    }
}