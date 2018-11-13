package com.wei.androidtraining.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

/**
 * DataBinding 实体类，双向绑定
 * @author XiangWei
 * @since 2018/11/13
 */
class Student : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var gender: String = "女"
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender)
        }

    @get:Bindable
    var age: Int = 22
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}