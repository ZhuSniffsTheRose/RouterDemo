package com.zhu.router

import android.app.Activity
import android.content.Intent
import android.widget.Toast

/**
 * @author Zhu
 * @date 2021/5/12 4:09 PM
 * @desc
 */
object RouterHandler {
    val routerMap = HashMap<String, Class<*>>()


    fun register(path: String, clz: Class<*>) {
        routerMap[path] = clz
    }

    fun startActivity(activity: Activity, path: String) {
        val clazz = routerMap[path]
        if (clazz != null) {
            activity.startActivity(Intent(activity, clazz))
        }else{
            Toast.makeText(activity, "not found the path", Toast.LENGTH_SHORT).show()
        }
    }
}