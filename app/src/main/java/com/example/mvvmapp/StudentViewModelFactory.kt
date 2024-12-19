package com.example.mvvmapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.viewModels.StudentViewModel

class StudentViewModelFactory {
    class StudentViewModelFactory(private val application: Application)
        : ViewModelProvider.AndroidViewModelFactory(application){
        override
        fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if(modelClass.isAssignableFrom(StudentViewModel::class.java)){
                StudentViewModel(application) as T
            }else{
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}