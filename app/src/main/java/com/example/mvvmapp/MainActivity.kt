package com.example.mvvmapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.viewModels.StudentViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        


    }
    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProvider(this,
            StudentViewModelFactory.StudentViewModelFactory(application)
        ).get(StudentViewModel::class.java)
    }
}