package com.example.metrologyapp.fragment.theory

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
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
import androidx.transition.ArcMotion
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.metrologyapp.R
import com.example.metrologyapp.databinding.FragmentThemeBinding
import com.example.metrologyapp.model.Theme
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.transition.MaterialContainerTransform
import javax.security.auth.callback.Callback


class ThemeFragment() : Fragment() {
    lateinit var binding: FragmentThemeBinding
    val args: ThemeFragmentArgs by navArgs()

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeBinding.inflate(inflater, container, false)

        sharedElementEnterTransition = TransitionInflater.from(this.requireContext()).inflateTransition(android.R.transition.fade)
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
            wvTheme.settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            wvTheme.loadDataWithBaseURL(null, currentTheme.text, "text/html", "utf-8", null)
            Glide.with(imToolbarTheme.context)
                .load(currentTheme.imageURL)
                .centerCrop()
                .error(R.drawable.ic_default)
                .into(imToolbarTheme)
        }

        val key = args.transition
        with(binding.imToolbarTheme) {
            transitionName = key
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

}