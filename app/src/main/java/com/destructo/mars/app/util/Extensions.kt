package com.destructo.mars.app.util

import android.text.Editable
import android.view.View


fun String.toEditable(): Editable {
   return Editable.Factory.getInstance().newEditable(this)
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}