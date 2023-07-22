package com.example.openeyessss

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}