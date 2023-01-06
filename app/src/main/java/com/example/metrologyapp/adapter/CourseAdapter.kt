package com.example.metrologyapp.adapter

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.metrologyapp.R
import com.example.metrologyapp.databinding.CourseItemBinding
import com.example.metrologyapp.model.Course
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.util.logging.Handler

class CourseAdapter(val listener: Listener): RecyclerView.Adapter<CourseAdapter.CourseHolder>() {
    private val courseList = ArrayList<Course>()

    class CourseHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = CourseItemBinding.bind(item)
        fun bind(course: Course, listener: Listener) = with(binding){

            Glide.with(itemView.context)
                .load(course.imageURL)
                .centerCrop()
                .error(R.drawable.ic_default)
                .into(imCourse)

            tvCourse.text = course.title
            itemView.setOnClickListener {
                listener.OnClick(course)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return CourseHolder(view)
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        holder.bind(courseList[position], listener)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    fun addCourse(course: Course){
        courseList.add(course)
        notifyDataSetChanged()
    }

    interface Listener{
        fun OnClick(course: Course)
    }
}


