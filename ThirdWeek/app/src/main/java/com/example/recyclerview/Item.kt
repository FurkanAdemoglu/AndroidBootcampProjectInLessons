package com.example.recyclerview

import android.util.Log

data class Item(
    var name:String,
    var description:String
){
    fun sayHello(){
        Log.v("Item","$name-$description")
    }
}
