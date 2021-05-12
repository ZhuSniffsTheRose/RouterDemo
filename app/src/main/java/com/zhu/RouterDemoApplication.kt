package com.zhu

import android.app.Application
import com.zhu.modulea.ModuleAMainActivity
import com.zhu.router.RouterHandler
import com.zhu.routerdemo.MainActivity

/**
 * @author Zhu
 * @date 2021/5/12 4:15 PM
 * @desc
 */
class RouterDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RouterHandler.register("main/main", MainActivity::class.java)
        RouterHandler.register("moduleA/main", ModuleAMainActivity::class.java)
    }
}