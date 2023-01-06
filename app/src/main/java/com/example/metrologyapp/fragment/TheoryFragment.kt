package com.example.metrologyapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metrologyapp.MainActivity
import com.example.metrologyapp.R
import com.example.metrologyapp.adapter.CourseAdapter
import com.example.metrologyapp.databinding.FragmentTheoryBinding
import com.example.metrologyapp.model.Course
import com.example.metrologyapp.model.Module
import com.example.metrologyapp.model.Theme


class TheoryFragment: Fragment(), CourseAdapter.Listener {
    val adapter = CourseAdapter(this)
    lateinit var binding: FragmentTheoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTheoryBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvCourse.layoutManager = LinearLayoutManager(activity)
            rvCourse.adapter = adapter
            val url = "https://tovaroveded.ru/wp-content/uploads/2020/09/185-metrologiya-v-zarubezhnykh-stranakh.jpeg"
            adapter.addCourse(Course("Метрология", url, null))
        }
    }

    override fun OnClick(course: Course) {
        Toast.makeText(activity, "Нажата: ${course.title}", Toast.LENGTH_SHORT).show()

        val themeList1= ArrayList<Theme>()
        themeList1.add(Theme("Метрология как наука", "Метрология как наукаМетрология как наука", "", null))
        themeList1.add(Theme("Основные и произодные величины", "Метрология как наукаМетрология как наука", "", null))
        themeList1.add(Theme("Средства и виды измерений в метрологии", "Метрология как наукаМетрология как наука", "", null))
        themeList1.add(Theme("Погрешности измерений", "Метрология как наукаМетрология как наука", "", null))
        themeList1.add(Theme("Эталоны в метрологии", "Метрология как наукаМетрология как наука", "", null))
        themeList1.add(Theme("Поверка и калибровка средств измерения", "Метрология как наукаМетрология как наука", "", null))

        val themeList2= ArrayList<Theme>()
        themeList2.add(Theme("Метрология как наука", "Метрология как наукаМетрология как наука", "", null))
        themeList2.add(Theme("Основные и произодные величины", "Метрология как наукаМетрология как наука", "", null))
        themeList2.add(Theme("Средства и виды измерений в метрологии", "Метрология как наукаМетрология как наука", "", null))

        val moduleList= ArrayList<Module>()
        moduleList.add(Module("Метрология", null, themeList1))
        moduleList.add(Module("Стандартизация", null, themeList2))

        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, ModuleFragment(moduleList))
            commit()
        }
    }

}