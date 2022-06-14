package com.sbdev.project.recyclerviewitemdecoration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sbdev.project.recyclerviewitemdecoration.databinding.RecyclerPersonInfoHorizontalBinding
import com.sbdev.project.recyclerviewitemdecoration.databinding.RecyclerPersonInfoVerticalBinding

class RecyclerListAdapter(
    private val list: List<PersonInfo>,
    private val orientation: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (orientation) {
            RecyclerView.VERTICAL -> {
                val binding = RecyclerPersonInfoVerticalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                VerticalViewHolder(binding)
            }
            RecyclerView.HORIZONTAL -> {
                val binding = RecyclerPersonInfoHorizontalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HorizontalViewHolder(binding)
            }
            else -> {
                val binding = RecyclerPersonInfoVerticalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                VerticalViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is VerticalViewHolder -> {
                holder.bindView(list[position])
            }
            is HorizontalViewHolder -> {
                holder.bindView(list[position])
            }
        }

    }

    override fun getItemCount(): Int = list.size

    inner class VerticalViewHolder(private val binding: RecyclerPersonInfoVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(personInfo: PersonInfo) {
            binding.tvPersonName.text = personInfo.personName
            binding.tvPersonInfo.text = personInfo.personInfo
        }

    }

    inner class HorizontalViewHolder(private val binding: RecyclerPersonInfoHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(personInfo: PersonInfo) {
            binding.tvPersonName.text = personInfo.personName
            binding.tvPersonInfo.text = personInfo.personInfo
        }

    }
}