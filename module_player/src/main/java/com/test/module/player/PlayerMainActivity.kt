package com.test.module.player

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import xyz.doikki.videocontroller.StandardVideoController
import xyz.doikki.videoplayer.player.VideoView


@Route(path = "/player/activity", group = "player")
class PlayerMainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    @Autowired
    lateinit var url:String

    @Autowired
    lateinit var title:String

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

        videoView = findViewById(R.id.player)
        videoView.setUrl(url) //设置视频地址

        val controller = StandardVideoController(this)
        controller.addDefaultControlComponent(title, false)
        videoView.setVideoController(controller) //设置控制器

        videoView.start() //开始播放，不调用则不自动播放
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