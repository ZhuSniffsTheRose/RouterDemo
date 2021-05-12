package com.zhu.routerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zhu.router.RouterHandler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun doJumpToOtherModule(view: View) {
        RouterHandler.startActivity(this, "moduleA/main")
    }
}