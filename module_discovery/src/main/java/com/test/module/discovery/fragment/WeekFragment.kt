package com.test.module.discovery.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.module.discovery.R
import com.test.module.discovery.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class WeekFragment : Fragment() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disposable = ApiManager.getWeekly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ weekly ->
                // 处理 itemList 数据
                for (item in weekly.itemList) {
                    Log.d("ggg", item.data.title)
                }
            }, { error ->
                // 处理错误情况
                Log.e("ggg", "请求出错: ${error.message}")
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_week, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        // 取消订阅
        disposable?.dispose()
    }
}