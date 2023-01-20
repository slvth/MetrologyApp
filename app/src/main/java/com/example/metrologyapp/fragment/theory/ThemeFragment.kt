package com.example.metrologyapp.fragment.theory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.metrologyapp.databinding.FragmentThemeBinding
import com.example.metrologyapp.model.Theme


class ThemeFragment() : Fragment() {
    lateinit var binding: FragmentThemeBinding
    val args: ThemeFragmentArgs by navArgs()

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeBinding.inflate(inflater, container, false)
        val currentTheme = args.currentTheme
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.toolbarTheme.setupWithNavController(findNavController(), appBarConfiguration)
        binding.toolbarTheme.title = currentTheme.title

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentTheme = args.currentTheme


        binding.apply {
            tvTheme.text = currentTheme.title
            wvTheme.settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            wvTheme.loadDataWithBaseURL(null, currentTheme.text, "text/html", "utf-8", null)


        }
    }

}