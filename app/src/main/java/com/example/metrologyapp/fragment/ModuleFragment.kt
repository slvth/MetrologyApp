package com.example.metrologyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metrologyapp.R
import com.example.metrologyapp.adapter.ModuleAdapter
import com.example.metrologyapp.adapter.ThemeAdapter
import com.example.metrologyapp.databinding.FragmentModuleBinding
import com.example.metrologyapp.model.Module
import com.example.metrologyapp.model.Theme


class ModuleFragment(val moduleList: ArrayList<Module>) : Fragment(), ModuleAdapter.ListenerModule, ThemeAdapter.ListenerTheme {
    lateinit var binding: FragmentModuleBinding
    private lateinit var adapterModule: ModuleAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModuleBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.apply {
            adapterModule = ModuleAdapter(moduleList,this@ModuleFragment, this@ModuleFragment)
            rvModule.layoutManager = LinearLayoutManager(activity)
            rvModule.adapter = adapterModule
        }

        return view
    }

    override fun onClick(module: Module) {
        Toast.makeText(context, "Нажали на модуль: ${module.title}", Toast.LENGTH_SHORT).show()
    }

    override fun OnClick(theme: Theme) {
        Toast.makeText(context, "Нажали на тему: ${theme.title}", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, ThemeFragment(theme))
            commit()
        }
    }

}