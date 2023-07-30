package com.test.module.discovery.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.module.discovery.network.ApiManager
import com.test.module.discovery.data.MonthlyBean
import com.test.module.discovery.data.TotalBean
import com.test.module.discovery.data.WeeklyBean
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *作者：sleepingfishboy
 *时间：2023/7/28

 */
class DiscoveryViewModel : ViewModel() {
    private val monthlyData: MutableLiveData<List<MonthlyBean.Item>> = MutableLiveData()
    private val weeklyData: MutableLiveData<List<WeeklyBean.Item>> = MutableLiveData()
    private val totalData: MutableLiveData<List<TotalBean.Item>> = MutableLiveData()
    private var disposable: Disposable? = null

    // 定义需要用到的LiveData
    fun getMonthlyData(): MutableLiveData<List<MonthlyBean.Item>> {
        return monthlyData
    }
    fun getWeeklyData(): MutableLiveData<List<WeeklyBean.Item>> {
        return weeklyData
    }
    fun getTotalData(): MutableLiveData<List<TotalBean.Item>> {
        return totalData
    }

    // 在这里进行数据的获取和处理
    fun loadMonthlyData() {
         disposable = ApiManager.getMonthly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ monthly ->
                Log.d("ggg", monthly.itemList.toString())
                monthlyData.value = monthly.itemList
            }, { error ->
                // 处理订阅过程中可能发生的错误
                error.printStackTrace()
                // 显示错误提示或执行其他适当的错误处理操作
            })

    }
    fun loadWeeklyData() {
        disposable = ApiManager.getWeekly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ weekly ->
                Log.d("ggg", weekly.itemList.toString())
                weeklyData.value = weekly.itemList
            }, { error ->
                // 处理订阅过程中可能发生的错误
                error.printStackTrace()
                // 显示错误提示或执行其他适当的错误处理操作
            })

    }
    fun loadTotalData() {
        disposable = ApiManager.getTotal()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ total ->
                Log.d("ggg", total.itemList.toString())
                totalData.value = total.itemList
            }, { error ->
                // 处理订阅过程中可能发生的错误
                error.printStackTrace()
                // 显示错误提示或执行其他适当的错误处理操作
            })

    }
    // 取消数据加载请求
    fun cancelDataRequest() {
        disposable?.dispose()
    }
}