package com.example.databaseactivity2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey
    val id:Int,
    val name:String) : Parcelable