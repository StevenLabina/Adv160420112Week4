package com.example.adv160420112week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420112week4.R
import com.example.adv160420112week4.databinding.StudentListItemBinding
import com.example.adv160420112week4.model.Student
import com.example.adv160420112week4.util.loadImage
import com.example.adv160420112week4.view.StudentListFragmentDirections.Companion as StudentListFragmentDirections1

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener{

    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater,
        R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        val txtID=holder.view.findViewById<TextView>(R.id.txtID)
//        txtID.text = studenList[position].id
//        val txtName=holder.view.findViewById<TextView>(R.id.txtName)
//        txtName.text = studenList[position].id
//        val btnDetail =holder.view.findViewById<TextView>(R.id.btnDetail)
//        btnDetail.setOnClickListener(){
//            var id = "0"
//            studenList[position].id?.let{
//                id = it
//            }
//            val action = StudentListFragmentDirections.actionStudentDetail(id)
//            Navigation.findNavController(it).navigate(action)
//        }
//        var imageView = holder.view.findViewById<ImageView>(R.id.image)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studenList[position].photoUrl, progressBar)
    }
    override fun getItemCount(): Int {
        return studenList.size
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()

    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }


}
