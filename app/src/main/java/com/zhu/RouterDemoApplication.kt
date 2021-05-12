package com.zhu

import android.app.Application
import com.zhu.router.RouterManager

/**
 * @author Zhu
 * @date 2021/5/12 4:15 PM
 * @desc
 */
class RouterDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        RouterManager.getInstance().init(this)
    }
}