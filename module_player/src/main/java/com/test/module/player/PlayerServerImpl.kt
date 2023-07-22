package com.test.module.player

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib.api.IMainService

@Route(path = "/player/activity")
interface PlayerServerImpl:IMainService {
    override fun toPage(context: Context) {
        PlayerMainActivity.startActivity(context)
    }

    override fun getInfo(): String {
        TODO("Not yet implemented")
    }

    override fun init(context: Context?) {

    }
}