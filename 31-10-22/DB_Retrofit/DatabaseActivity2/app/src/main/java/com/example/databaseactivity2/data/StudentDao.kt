package com.example.databaseactivity2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databaseactivity2.model.Student

@Dao
interface StudentDao {
    @Insert
     fun addStudent(student: Student)

    @Delete
     fun deleteStudent(student: Student)

    @Update
     fun updateStudent(student: Student)

    @Query("delete from student_table where id=:id" )
     fun deleteStudentById(id:Int)

    @Query("select * from student_table")
     fun getAllStudents(): List<Student>
}