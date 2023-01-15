package com.example.metrologyapp.fragment.theory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import com.example.metrologyapp.databinding.FragmentThemeBinding
import com.example.metrologyapp.model.Theme


class ThemeFragment(val theme: Theme) : Fragment() {
    lateinit var binding: FragmentThemeBinding

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            tvTheme.text = theme.title
            wvTheme.settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            wvTheme.loadDataWithBaseURL(null, "htmlAsString", "text/html", "utf-8", null)
        }


        return view
    }

}