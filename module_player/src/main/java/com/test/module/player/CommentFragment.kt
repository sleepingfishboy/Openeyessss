package com.test.module.player

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.module.player.adapter.CommentAdapter
import com.test.module.player.network.ApiManager

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class CommentFragment : BottomSheetDialogFragment() {


    private lateinit var recyclerView: RecyclerView
    private var disposable: Disposable? = null
    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        val id = arguments?.getString(ARG_ID)
        recyclerView = view.findViewById(R.id.rv_comment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //recyclerView.isNestedScrollingEnabled = false

        adapter = CommentAdapter()
        recyclerView.adapter = adapter
        disposable = id?.let {
            ApiManager.getComments(it)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.onErrorResumeNext { throwable: Throwable ->
                    Observable.error(Exception("API Error: ${throwable.message}"))
                }
                ?.subscribe({ commentItems ->
                    adapter.setCommentData(commentItems.itemList)
                }, { error ->
                    // 处理订阅过程中可能发生的错误
                    error.printStackTrace()
                    // 显示错误提示或执行其他适当的错误处理操作
                })
        }

        return view
    }

    companion object {
        private const val ARG_ID = "id"

        fun newInstance(id: String): CommentFragment {
            val args = Bundle()
            args.putString(ARG_ID, id)
            val fragment = CommentFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
