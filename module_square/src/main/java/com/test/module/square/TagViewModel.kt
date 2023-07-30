package com.test.module.square

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.ApiManager

class TagViewModel:ViewModel() {
    private var disposable:Disposable?=null
    private var adDataList:MutableLiveData<MutableList<Advertisement.Item>>?=null
    private var exeDataList:MutableLiveData<MutableList<Exercise.Item>>?=null
    private var musicDataList:MutableLiveData<MutableList<Music.Item>>?=null
    private var dramaDataList:MutableLiveData<MutableList<Drama.Item>>?=null
    private var funnyDataList:MutableLiveData<MutableList<Funny.Item>>?=null
    private var foodDataList:MutableLiveData<MutableList<Food.Item>>?=null

    //根据传入的id请求对应的数据
    fun setDisposable(id:Int){
        when(id){
            0->disposable = ApiManager.getAd()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setAdData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
            1->disposable = ApiManager.getExercise()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setExeData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
            2->disposable = ApiManager.getMusic()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setMusicData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
            3->disposable = ApiManager.getDrama()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setDramaData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
            4->disposable = ApiManager.getFunny()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setFunnyData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
            5->disposable = ApiManager.getFood()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ data ->
                    setFoodData(data.itemList)
                },{ throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
        }
    }

    private fun setAdData(items:List<Advertisement.Item>){
        val list= mutableListOf<Advertisement.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        adDataList?.value=list
    }

    fun getAdData():LiveData<MutableList<Advertisement.Item>>{
        if (adDataList == null) {
            adDataList = MutableLiveData()
        }
        return adDataList!!
    }

    private fun setExeData(items:List<Exercise.Item>){
        val list= mutableListOf<Exercise.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        exeDataList?.value=list
    }

    fun getExeData():LiveData<MutableList<Exercise.Item>>{
        if (exeDataList==null){
            exeDataList= MutableLiveData()
        }
        return exeDataList!!
    }

    private fun setMusicData(items:List<Music.Item>){
        val list= mutableListOf<Music.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        musicDataList?.value=list
    }

    fun getMusicData():LiveData<MutableList<Music.Item>>{
        if (musicDataList==null){
            musicDataList= MutableLiveData()
        }
        return musicDataList!!
    }

    private fun setDramaData(items:List<Drama.Item>){
        val list= mutableListOf<Drama.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        dramaDataList?.value=list
    }

    fun getDramaData():LiveData<MutableList<Drama.Item>>{
        if (dramaDataList==null){
            dramaDataList= MutableLiveData()
        }
        return dramaDataList!!
    }

    private fun setFunnyData(items:List<Funny.Item>){
        val list= mutableListOf<Funny.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        funnyDataList?.value=list
    }

    fun getFunnyData():LiveData<MutableList<Funny.Item>>{
        if (funnyDataList==null){
            funnyDataList= MutableLiveData()
        }
        return funnyDataList!!
    }

    private fun setFoodData(items:List<Food.Item>){
        val list= mutableListOf<Food.Item>()
        for (i in items.indices){
            if (items[i].data.content.data!=null)
                list.add(items[i])
        }
        foodDataList?.value=list
    }

    fun getFoodData():LiveData<MutableList<Food.Item>>{
        if (foodDataList==null){
            foodDataList= MutableLiveData()
        }
        return foodDataList!!
    }
}