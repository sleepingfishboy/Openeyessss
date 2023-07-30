package com.test.module.player.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.module.player.R
import com.test.module.player.adapter.CommentAdapter
import com.test.module.player.network.ApiManager
import com.test.module.player.viewmodel.CommentViewModel

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class CommentFragment : BottomSheetDialogFragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CommentAdapter
    private lateinit var commentViewModel: CommentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        val id = arguments?.getString(ARG_ID)
        recyclerView = view.findViewById(R.id.rv_comment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        adapter = CommentAdapter()
        recyclerView.adapter = adapter
        commentViewModel = ViewModelProvider(this).get(CommentViewModel::class.java)
        commentViewModel.commentItems.observe(viewLifecycleOwner) { commentItems ->
            adapter.setCommentData(commentItems)
        }

        id?.let {
            commentViewModel.loadComments(it)
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
