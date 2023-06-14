package com.example.adv160420112week4.model

data class Student(
    val id:String?,
  //@SerializedName("student_name")
    val student_name:String?,
    val birth_of_date:String?,
    val phone:String?,
    val photo_url:String?
)