package com.example.metrologyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.metrologyapp.R
import com.example.metrologyapp.databinding.ThemeItemBinding
import com.example.metrologyapp.model.Theme

class ThemeAdapter(val themeList: ArrayList<Theme>, val listener: ListenerTheme): RecyclerView.Adapter<ThemeAdapter.ThemeHolder>() {

    class ThemeHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ThemeItemBinding.bind(item)
        fun bind(theme: Theme, listener: ListenerTheme) = with(binding){

            Glide.with(itemView.context)
                .load(theme.imageURL)
                .centerCrop()
                .error(R.drawable.ic_default)
                .into(imTheme)

            tvTheme.text = theme.title
            itemView.setOnClickListener {
                listener.OnClick(theme)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.theme_item, parent, false)
        return ThemeHolder(view)
    }

    override fun onBindViewHolder(holder: ThemeHolder, position: Int) {
        holder.bind(themeList[position], listener)
    }

    override fun getItemCount(): Int {
        return themeList.size
    }

    fun addTheme(theme: Theme){
        themeList.add(theme)
        notifyDataSetChanged()
    }

    interface ListenerTheme{
        fun OnClick(theme: Theme)
    }
}


