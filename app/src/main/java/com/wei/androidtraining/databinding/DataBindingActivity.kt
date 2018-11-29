package com.wei.androidtraining.databinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.wei.androidtraining.R
import com.wei.androidtraining.model.OneWay
import com.wei.androidtraining.model.Student
import com.wei.androidtraining.model.Teacher
import com.wei.androidtraining.model.User

class DataBindingActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var student: Student
    private lateinit var teacher: Teacher
    private lateinit var oneWay: OneWay
    val showLiveData = MutableLiveData<Boolean>()

    companion object {
        const val color = R.color.colorAccent
    }

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

        var nameLive = MutableLiveData<String>()
        nameLive.value = "Mrs Li"
        nameLive.observe(this, Observer {
            Log.e("observer:", nameLive.value)
        })
        var genderLive = MutableLiveData<String>()
        genderLive.value = "女"
        var ageLive = MutableLiveData<Int>()
        ageLive.value = 22
        teacher = Teacher(nameLive, genderLive, ageLive)

        oneWay = OneWay("单向绑定")

        binding.user = user
        binding.student = student
        binding.teacher = teacher
        binding.oneWay = oneWay

        binding.owner = this
        binding.setClickListener {
            onClickTv(it)
        }
    }

    private fun onClickTv(view: View) {
        when (view.id) {
            R.id.tv_name_student -> {
                student.name = "newstudent"
            }
            R.id.tv_name_user -> {
                user.userName = "newuser"
            }
            R.id.tv_name_teacher -> {
                teacher.name.value = "Mr Cai"
            }
            R.id.tv_name_one_way -> {
                oneWay.name = "现在是双向绑定了"
            }
        }
    }
}
