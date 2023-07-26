package com.test.module.player

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import xyz.doikki.videocontroller.StandardVideoController
import xyz.doikki.videoplayer.player.VideoView
import java.io.File


@Route(path = "/player/activity", group = "player")
class PlayerMainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var videoView: VideoView
    private var disposable: Disposable? = null
    private lateinit var adapter: RelevantAdapter


    @Autowired
    lateinit var url: String

    @Autowired
    lateinit var title: String

    @Autowired
    lateinit var description: String

    @Autowired
    lateinit var id: String

    @Autowired
    lateinit var webUrl: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_main)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    )
            window.statusBarColor = Color.TRANSPARENT
        }

        ARouter.getInstance().inject(this)

        Log.d("ggg","(:)-->> $id")

        val mIvLike: ImageView? = findViewById(R.id.iv_like)
        val mIvComment: ImageView? = findViewById(R.id.iv_comment)
        val mIvTransmit: ImageView? = findViewById(R.id.iv_transmit)
        val mIvDownload: ImageView? = findViewById(R.id.iv_download)

        val mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        mVibrator.vibrate(1)

        mIvDownload?.setOnClickListener {
            mVibrator.vibrate(50)
            Log.d("ggg","(:)-->> 下载")
            Toast.makeText(this, "开始下载", Toast.LENGTH_SHORT).show()
            val mDownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager


            val resource = Uri.parse(url)

            val request = DownloadManager.Request(resource)

            request.setDestinationInExternalPublicDir("Download","$title.mp4")


            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setVisibleInDownloadsUi(true)



            mDownloadManager.enqueue(request)

        }

        mIvTransmit?.setOnClickListener {
            mVibrator.vibrate(50)
            allShare(this, webUrl)
        }
        mIvComment?.setOnClickListener {

            mVibrator.vibrate(50)
            val fragment = CommentFragment.newInstance(id)
            fragment.show(supportFragmentManager, "comment_dialog")
        }

        var isClicked = false // 标志位，默认为未点击状态

        mIvLike?.setOnClickListener {
            mVibrator.vibrate(50)
            isClicked = if (isClicked) {
                Toast.makeText(this, "这个视频不太好🙈", Toast.LENGTH_SHORT).show()

                false
            } else {
                Toast.makeText(this, "这个视频不错\uD83D\uDC95", Toast.LENGTH_SHORT).show()
                true
            }


        }
        val des: TextView = findViewById(R.id.tv_cv_intro)
        des.text = title + "\n" + "\n" + description
        if (id != null) {
            recyclerView = findViewById(R.id.rv_relevant)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.isNestedScrollingEnabled = false

            adapter = RelevantAdapter()
            recyclerView.adapter = adapter
            disposable = ApiManager.getRelatedVideos(id)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { relevantVideos ->
                    adapter.setRelevantData(relevantVideos.itemList)
                }
        }

        videoView = findViewById(R.id.player)
        videoView.setUrl(url) //设置视频地址

        val controller = StandardVideoController(this)
        controller.addDefaultControlComponent(title, false)
        videoView.setVideoController(controller) //设置控制器



        videoView.start() 

    }

    private fun allShare(context: Context, content: String) {
        val intent = Intent()
        // 设置分享行为
        intent.action = Intent.ACTION_SEND
        // 设置分享内容的类型
        intent.type = "text/plain"
        // 添加分享内容标题
        intent.putExtra(Intent.EXTRA_SUBJECT, "好好")
        // 添加分享内容
        intent.putExtra(Intent.EXTRA_TEXT, content)
        // 创建分享的 Dialog
        val shareIntent = Intent.createChooser(intent, "")
        context.startActivity(shareIntent)
    }


    override fun onPause() {
        super.onPause()
        videoView.pause()
    }

    override fun onResume() {
        super.onResume()
        videoView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.release()
    }


    override fun onBackPressed() {
        if (!videoView.onBackPressed()) {
            super.onBackPressed()
        }
    }
}