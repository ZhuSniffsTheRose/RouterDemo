package com.zhu.haha

import android.util.Log
import com.zhu.modulea.ModuleAMainActivity
import com.zhu.router.IRouter

/**
 * @author Zhu
 * @date 2021/5/12 4:38 PM
 * @desc
 */
class ModuleARouterImpl : IRouter {

    override fun loadRouterInfo(routerMap: HashMap<String, Class<*>>) {
        routerMap["MODULE_A_MAIN_ACTIVITY"] = ModuleAMainActivity::class.java
        Log.d("heiheihei", "ModuleARouterImpl loadRouterInfo: ")
    }
}