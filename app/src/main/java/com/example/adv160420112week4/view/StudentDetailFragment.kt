package com.example.adv160420112week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420112week4.R
import com.example.adv160420112week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420112week4.util.loadImage
import com.example.adv160420112week4.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_detail.txtID
import kotlinx.android.synthetic.main.fragment_student_detail.txtName
import kotlinx.android.synthetic.main.student_list_item.*
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        if(arguments != null){
//            val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
//            viewModel.fetch(studentId)
//            observeViewModel()
//        }
        observeViewModel()
    }
    fun observeViewModel() {

        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
    }
}