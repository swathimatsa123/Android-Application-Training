package com.example.databaseactivity2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.databaseactivity2.data.StudentDatabase
import com.example.databaseactivity2.model.Student
import com.example.databaseactivity2.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {
    val getAllStudents:List<Student>
    val studentRepository:StudentRepository

    init {
        val studentDao = StudentDatabase.getDatabase(application).studentDao()
        studentRepository = StudentRepository(studentDao)
        getAllStudents = studentRepository.getAllStudents
    }
    fun addStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.addStudent(student)
        }

    }
    fun deleteStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.deleteStudent(student)
        }
    }
    fun updateStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.updateStudent(student)
        }
    }
    fun deleteStudentById(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.deleteStudentById(id)
        }
    }

}