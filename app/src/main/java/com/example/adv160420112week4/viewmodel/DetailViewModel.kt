package com.example.adv160420112week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420112week4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application):
AndroidViewModel(application){
    val studentsLD = MutableLiveData<Student>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    fun fetch(id:String) {
        loadingLD.value = true
        studentLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id="+id
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object: TypeToken<Student>(){}.type
                val result = Gson().fromJson<Student>(it, sType)
                studentsLD.value = result
                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                studentLoadErrorLD.value = false
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
//        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
//            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        studentLD.value = student1
    }



}
