package com.example.metrologyapp.fragment.theory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metrologyapp.R
import com.example.metrologyapp.adapter.CourseAdapter
import com.example.metrologyapp.databinding.FragmentCourseBinding
import com.example.metrologyapp.model.Course
import com.example.metrologyapp.model.Module
import com.example.metrologyapp.model.Theme


class CourseFragment: Fragment(), CourseAdapter.Listener {
    lateinit var adapter: CourseAdapter
    lateinit var binding: FragmentCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            rvCourse.layoutManager = LinearLayoutManager(activity)


            val url = "https://tovaroveded.ru/wp-content/uploads/2020/09/185-metrologiya-v-zarubezhnykh-stranakh.jpeg"
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

            adapter = CourseAdapter(this@CourseFragment,this@CourseFragment.binding.root)
            rvCourse.adapter = adapter

            adapter.addCourse(Course("Метрология", url, moduleList))




            //rvCourse.addOnItemTouchListener()
        }
    }

    override fun OnClick(course: Course) {
        Toast.makeText(this.context, "fsefsefsef", Toast.LENGTH_SHORT).show()
        val action = CourseFragmentDirections.actionCourseFragmentToModuleFragment(course)
        findNavController().navigate(action)
    }

}