package com.example.mvvmapp.repository

import androidx.lifecycle.LiveData
import com.example.mvvmapp.DAOS.StudentDao
import com.example.mvvmapp.models.Student

class StudentRepository(private val studentDao: StudentDao) {
    // Room execute toutes les requêtes dans un thread séparé.
// Observed LiveData will notify the observer when the data has changed.
    val allStudents: LiveData<List<Student>> = studentDao.getStudents()
    suspend fun insert(student: Student){
        studentDao.insert(student)
    }
}