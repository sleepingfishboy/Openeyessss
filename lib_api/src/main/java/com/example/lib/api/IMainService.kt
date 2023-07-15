package com.example.lib.api

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

interface IMainService:IProvider {
    fun toPage(context: Context)

    fun getInfo():String
}