package com.example.lib.common

import android.app.Application

/**
 *作者：sleepingfishboy
 *时间：2023/7/22

 */
open class BaseApp: Application() {
    companion object {
        lateinit var mContext: BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        mContext=this
    }
}