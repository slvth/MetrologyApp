package com.example.metrologyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.metrologyapp.R
import com.example.metrologyapp.databinding.ModuleItemBinding
import com.example.metrologyapp.model.Module

class ModuleAdapter(val moduleList: ArrayList<Module>,val listenerModule: ListenerModule, val listenerTheme: ThemeAdapter.ListenerTheme): RecyclerView.Adapter<ModuleAdapter.ModuleHolder>() {

    private lateinit var context : Context

    class ModuleHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ModuleItemBinding.bind(item)
        fun bind(module: Module, listener: ListenerModule, listenerTheme: ThemeAdapter.ListenerTheme, context: Context) = with(binding){
            tvModule.text = module.title
            rvTheme.layoutManager = LinearLayoutManager(context)
            rvTheme.adapter = ThemeAdapter(module.themes, listenerTheme)
            itemView.setOnClickListener{
                listener.onClick(module)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.module_item, parent, false)
        return ModuleHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleHolder, position: Int) {
        holder.bind(moduleList[position], listenerModule, listenerTheme, context)
    }

    override fun getItemCount(): Int {
        return moduleList.size
    }

    fun addModule(module: Module){
        moduleList.add(module)
        notifyDataSetChanged()
    }

    interface ListenerModule{
        fun onClick(module: Module)
    }
}