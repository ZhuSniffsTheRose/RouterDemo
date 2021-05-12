package com.zhu.haha

import android.util.Log
import com.zhu.router.IRouter
import com.zhu.routerdemo.MainActivity
import com.zhu.routerdemo.RouterConst.MAIN_ACTIVITY

/**
 * @author Zhu
 * @date 2021/5/12 4:38 PM
 * @desc
 */
class MainRouterImpl : IRouter {
    override fun loadRouterInfo(routerMap: HashMap<String, Class<*>>) {
        routerMap[MAIN_ACTIVITY] = MainActivity::class.java
        Log.d("heiheihei", "MainRouterImpl loadRouterInfo: ")
    }
}