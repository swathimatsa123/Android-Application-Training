package com.example.databaseactivity2.repository

import androidx.lifecycle.LiveData
import com.example.databaseactivity2.data.StudentDao
import com.example.databaseactivity2.model.Student

class StudentRepository(private val studentDao: StudentDao) {
    val getAllStudents:List<Student> = studentDao.getAllStudents()

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }
    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }
    suspend fun updateStudent(student: Student){
        studentDao.updateStudent(student)
    }
    fun deleteStudentById(id:Int){
        studentDao.deleteStudentById(id)
    }

}