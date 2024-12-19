package com.example.mvvmapp.DAOS

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmapp.models.Student

@Dao
interface StudentDao {
    @Query("SELECT * from student_table ORDER BY firstName ASC")
    fun getStudents(): LiveData<List<Student>>
    @Query("SELECT * FROM student_table WHERE id=(:id)")
    fun getStudent(id: Int): LiveData<Student?>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)
    @Update
    fun updateStudent(student: Student)
    @Query("DELETE FROM student_table")
    fun deleteAll()
}