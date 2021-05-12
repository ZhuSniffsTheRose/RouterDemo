package com.zhu.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * @author Zhu
 * @date 2021/5/12 4:09 PM
 * @desc
 */
object RouterHandler {
    val routerMap = HashMap<String, Class<*>>()


    fun init(context: Context) {
//        routerMap[path] = clz


        //  遍历项目中所有类， 实现了 IRouter 接口的， 都调用 loadRouterInfo

//        val a =  RouterImpl()
//        val b =  RouterImpl()
//        a.loadRouterInfo(routerMap)
//        b.loadRouterInfo(routerMap)
        // 但是 Router 属于下层模块， 对上层无感知， 所以就不能获取对应的类.

        // 这里就需要通过 DexFile 去遍历所有类。

        val scanResult = ClassScanner().scan(context, "com.zhu.haha")

        scanResult.forEach {
            val cls = Class.forName(it.toString())
            if (cls.isAssignableFrom(IRouter::class.java)) {
                val iRouter = cls.newInstance() as IRouter
                iRouter.loadRouterInfo(routerMap)
            }
        }

    }


    fun startActivity(activity: Activity, path: String) {
        val clazz = routerMap[path]
        if (clazz != null) {
            activity.startActivity(Intent(activity, clazz))
        } else {
            Toast.makeText(activity, "not found the path", Toast.LENGTH_SHORT).show()
        }
    }
}