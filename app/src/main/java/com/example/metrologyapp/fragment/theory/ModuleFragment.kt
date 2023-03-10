package com.example.metrologyapp.fragment.theory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metrologyapp.adapter.ModuleAdapter
import com.example.metrologyapp.adapter.ThemeAdapter
import com.example.metrologyapp.databinding.FragmentModuleBinding
import com.example.metrologyapp.model.Module
import com.example.metrologyapp.model.Theme
import com.google.android.material.transition.MaterialElevationScale


class ModuleFragment() : Fragment(), ModuleAdapter.ListenerModule, ThemeAdapter.ListenerTheme {
    lateinit var binding: FragmentModuleBinding
    private lateinit var adapterModule: ModuleAdapter
    private val args by navArgs<ModuleFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModuleBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moduleList = args.currentCourse.modules
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)

        binding.apply {
            adapterModule = ModuleAdapter(moduleList,this@ModuleFragment, this@ModuleFragment)
            rvModule.layoutManager = LinearLayoutManager(activity)
            rvModule.adapter = adapterModule


            toolbarModule.setupWithNavController(findNavController(), appBarConfiguration)
            toolbarModule.title = args.currentCourse.title
        }
    }

    override fun onClick(module: Module) {
        Toast.makeText(context, "???????????? ???? ????????????: ${module.title}", Toast.LENGTH_SHORT).show()
    }

    override fun OnClick(theme: Theme, transitionName: String) {
        Toast.makeText(context, "???????????? ???? ????????: ${theme.title}", Toast.LENGTH_SHORT).show()
        val action = ModuleFragmentDirections.actionModuleFragmentToThemeFragment(theme, transitionName)
        findNavController().navigate(action)
    }

}