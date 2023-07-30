package com.test.module.player.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.module.player.data.CommentBean
import com.test.module.player.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *作者：sleepingfishboy
 *时间：2023/7/30

 */
class CommentViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val comments: MutableLiveData<List<CommentBean.Item>> = MutableLiveData()
    val commentItems: LiveData<List<CommentBean.Item>>
        get() = comments

    fun loadComments(id: String) {
        val disposable = ApiManager.getComments(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ commentItems ->
                comments.value = commentItems.itemList
            }, { error ->
                error.printStackTrace()
            })
        disposable?.let {
            compositeDisposable.add(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}