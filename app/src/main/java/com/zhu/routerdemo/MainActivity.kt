package com.zhu.routerdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zhu.haha.MainRouterImpl
import com.zhu.router.RouterManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainRouterImpl()
    }

    fun doJumpToOtherModule(view: View) {
        RouterManager.getInstance().startActivity(this, "MODULE_A_MAIN_ACTIVITY")
    }
}