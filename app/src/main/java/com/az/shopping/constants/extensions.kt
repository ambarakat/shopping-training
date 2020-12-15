package com.az.shopping.constants

import android.app.Activity
import android.content.Context


fun String.setSharedPref(context: Activity, value: String) {
    val sharedPref = context.getSharedPreferences(AppConstants.SHARED_PREF,Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putString(this@setSharedPref, value)
        apply()
    }
}

fun String.deleteSharedPref(context: Context) {
    val sharedPref = context.getSharedPreferences(AppConstants.SHARED_PREF,Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        remove(this@deleteSharedPref)
        apply()
    }
}

fun String.getSharedPref(context: Activity, defVal: String): String {
    val sharedPref = context.getSharedPreferences(AppConstants.SHARED_PREF,Context.MODE_PRIVATE) ?: return defVal
    return sharedPref.getString(this, defVal) ?: defVal
}
