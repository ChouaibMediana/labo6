package com.example.mvvmapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.models.Student

class StudentListAdapter constructor(
    context: Context
) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var students = emptyList<Student>() // Cached copy of students
    inner class StudentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val fullNameItemView: TextView =
            itemView.findViewById(R.id.fullNameView)
        val phoneNumberItemView: TextView =
            itemView.findViewById(R.id.phoneNumberView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            StudentViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent,
            false)
        return StudentViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = students[position]
        holder.fullNameItemView.text = "${current.firstName} ${current.lastName}"
        holder.phoneNumberItemView.text = "${current.phoneNumber}"
    }
    fun setStudents(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }
    override fun getItemCount() = students.size
}