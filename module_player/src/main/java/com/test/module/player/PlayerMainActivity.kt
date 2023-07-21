package com.test.module.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.doikki.videocontroller.StandardVideoController
import xyz.doikki.videoplayer.player.VideoView


class PlayerMainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_main)
        videoView = findViewById(R.id.player)
        videoView.setUrl("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=317736&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=") //设置视频地址

        val controller = StandardVideoController(this)
        controller.addDefaultControlComponent("标题", false)
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