package com.wei.androidtraining.model

import android.arch.lifecycle.MutableLiveData

class Teacher {

     var name = MutableLiveData<String>()
     var gender = MutableLiveData<String>()
     var age = MutableLiveData<Int>()

     constructor(name: MutableLiveData<String>, gender: MutableLiveData<String>, age: MutableLiveData<Int>) {
          this.name = name
          this.gender = gender
          this.age = age
     }


}