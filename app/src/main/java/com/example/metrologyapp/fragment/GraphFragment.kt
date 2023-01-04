package com.example.metrologyapp.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.metrologyapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class GraphFragment : Fragment() {

    lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_graph, container, false)

        lineChart = v.findViewById(R.id.line_chart_main)
        makeLineChart()

        return v
    }

    private fun makeLineChart(){
        val entries1: ArrayList<Entry> = ArrayList<Entry>() //Кельвин
        var i = 0f
        while (i <= 400) {
            entries1.add(Entry(i, 40f))
            i += 0.15f
        }

        val entries2: ArrayList<Entry> = ArrayList<Entry>() //Цельсия
        i = 0f
        while (i <= 400) {
            entries2.add(Entry(i, 30f))
            i += 0.15f
        }

        val entries3: ArrayList<Entry> = ArrayList<Entry>() //Реомюр
        i = 0f
        while (i <= 400) {
            entries3.add(Entry(i, 20f))
            i += 0.15f
        }

        val entries4: ArrayList<Entry> = ArrayList<Entry>() //Фаренгейт
        i = 0f
        while (i <= 400) {
            entries4.add(Entry(i, 10f))
            i += 0.15f
        }

        val entries5: ArrayList<Entry> = ArrayList<Entry>() //Ранкен
        i = 0f
        while (i <= 400) {
            entries5.add(Entry(i, 0f))
            i += 0.15f
        }


        lineChart.xAxis.granularity = 1f

        val lines = ArrayList<ILineDataSet>()
        val dataSet1 = LineDataSet(entries1, "Кельвин")
        dataSet1.valueFormatter = object : ValueFormatter() {
            override fun getPointLabel(entry: Entry): String {
                return String.format("%.2f", entry.x)
            }
        }

        val dataSet2 = LineDataSet(entries2, "Цельсия")
        dataSet2.valueFormatter = object : ValueFormatter() {
            override fun getPointLabel(entry: Entry): String {
                return String.format("%.2f", entry.x - 273.15)
            }
        }

        val dataSet3 = LineDataSet(entries3, "Реомюр")
        dataSet3.valueFormatter = object : ValueFormatter() {
            override fun getPointLabel(entry: Entry): String {
                return String.format("%.2f", entry.x * (5 / 4) + 273.15)
            }
        }

        val dataSet4 = LineDataSet(entries4, "Фаренгейт")
        dataSet4.valueFormatter = object : ValueFormatter() {
            override fun getPointLabel(entry: Entry): String {
                return String.format("%.2f", (entry.x - 273.15) * 9 / 5 + 32)
            }
        }

        val dataSet5 = LineDataSet(entries5, "Ранкен")
        dataSet5.valueFormatter = object : ValueFormatter() {
            override fun getPointLabel(entry: Entry): String {
                return String.format("%.2f", entry.x * 1.8)
            }
        }


        val font_size = 14

        dataSet1.color = Color.RED
        dataSet1.setCircleColor(Color.RED)
        dataSet1.valueTextSize = font_size.toFloat()

        dataSet2.valueTextSize = font_size.toFloat()

        dataSet3.color = Color.MAGENTA
        dataSet3.setCircleColor(Color.MAGENTA)
        dataSet3.valueTextSize = font_size.toFloat()

        dataSet4.color = Color.GREEN
        dataSet4.setCircleColor(Color.GREEN)
        dataSet4.valueTextSize = font_size.toFloat()

        dataSet5.color = Color.YELLOW
        dataSet5.setCircleColor(Color.YELLOW)
        dataSet5.valueTextSize = font_size.toFloat()

        lines.add(dataSet1)
        lines.add(dataSet2)
        lines.add(dataSet3)
        lines.add(dataSet4)
        lines.add(dataSet5)

        lineChart.data = LineData(lines)
        lineChart.invalidate()

        lineChart.setDrawGridBackground(true) //серый задний фон

        lineChart.description.isEnabled = false // выключить Description

        lineChart.animateX(1500)

        var ll = LimitLine(60f)
        val xAxis = lineChart.xAxis
        xAxis.axisMaximum = 400f
        xAxis.addLimitLine(ll)

        var x = 60
        while (x < 400) {
            ll = LimitLine(x.toFloat()) // set where the line should be drawn
            ll.lineColor = Color.RED
            ll.lineWidth = 1f
            xAxis.addLimitLine(ll)
            x += 60
        }

        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(true)
        xAxis.gridColor = resources.getColor(R.color.black)

        val yAxisRight = lineChart.axisRight
        yAxisRight.axisMaximum = 50f
        yAxisRight.setDrawAxisLine(true)
        yAxisRight.setDrawGridLines(true)
        yAxisRight.gridColor = resources.getColor(R.color.black)

        val yAxisLeft = lineChart.axisLeft
        yAxisLeft.axisMaximum = 50f
        yAxisLeft.setDrawGridLines(true)
        yAxisLeft.gridColor = resources.getColor(R.color.black)

        lineChart.isScaleYEnabled = false //отключение вертикального увеличения

    }
}