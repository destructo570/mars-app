package com.destructo.mars.app.util

import android.text.Editable


fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)