package com.wei.androidtraining.databinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.wei.androidtraining.R
import com.wei.androidtraining.model.Student
import com.wei.androidtraining.model.User

class DataBindingActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        一定要是如下写法，即：var binding: ActivityTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
//        或者泛型写法：  var binding = DataBindingUtil.setContentView<ActivityTestBinding>(this, R.layout.activity_test)

//        var binding = DataBindingUtil.setContentView<ActivityTestBinding>(this, R.layout.activity_test)
        var binding: ActivityTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        user = User("ugvv", 22)
        student = Student()
        student.name = "abcdefg"
        student.gender = "女"
        student.age = 22
        binding.user = user
        binding.student = student
//        setContentView(R.layout.activity_test)

        binding.setClickListener {
            onClickTv(it)
        }
    }

    private fun onClickTv(view: View) {
        when (view.id) {
            R.id.tv_name_student -> {student.name = "newstudent"}
            R.id.tv_name_user -> {user.userName = "newuser"}
        }
    }
}
