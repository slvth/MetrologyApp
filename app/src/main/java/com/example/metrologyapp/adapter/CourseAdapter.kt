package com.example.metrologyapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.metrologyapp.MainActivity
import com.example.metrologyapp.R
import com.example.metrologyapp.databinding.CourseItemBinding
import com.example.metrologyapp.fragment.theory.CourseFragmentDirections
import com.example.metrologyapp.model.Course
import kotlinx.coroutines.NonDisposableHandle.parent

class CourseAdapter(val listener: Listener,val viewParent: View): RecyclerView.Adapter<CourseAdapter.CourseHolder>() {
    private val courseList = ArrayList<Course>()

    class CourseHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = CourseItemBinding.bind(item)
        fun bind(course: Course, listener: Listener, viewParent: View) = with(binding){

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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return CourseHolder(view)
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        holder.bind(courseList[position], listener, viewParent)
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


