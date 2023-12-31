package com.test.module.square.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.test.module.square.R
import com.test.module.square.viewmodel.TagViewModel
import com.test.module.square.adapter.AdAdapter
import com.test.module.square.adapter.DramaAdapter
import com.test.module.square.adapter.ExeAdapter
import com.test.module.square.adapter.FoodAdapter
import com.test.module.square.adapter.FunnyAdapter
import com.test.module.square.adapter.MusicAdapter
import com.test.module.square.data.Advertisement
import com.test.module.square.data.Drama
import com.test.module.square.data.Exercise
import com.test.module.square.data.Food
import com.test.module.square.data.Funny
import com.test.module.square.data.Music

class TagActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adLiveData: MutableLiveData<MutableList<Advertisement.Item>>
    private lateinit var exeLiveData: MutableLiveData<MutableList<Exercise.Item>>
    private lateinit var musicLiveData: MutableLiveData<MutableList<Music.Item>>
    private lateinit var dramaLiveData: MutableLiveData<MutableList<Drama.Item>>
    private lateinit var funnyLiveData: MutableLiveData<MutableList<Funny.Item>>
    private lateinit var foodLiveData: MutableLiveData<MutableList<Food.Item>>
    private lateinit var tagName: String
    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolBar: CollapsingToolbarLayout
    private lateinit var image: ImageView
    private lateinit var textView: TextView

    private val viewModel by lazy { ViewModelProvider(this).get(TagViewModel::class.java) }
    private val networkChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // 处理网络变化情况
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            val isConnected = networkInfo != null && networkInfo.isConnected

            if (isConnected) {
                // 网络已连接，执行相应操作
            } else {
                // 网络已断开，显示错误信息
                Toast.makeText(context, "网络连接已断开", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    )
            window.statusBarColor = Color.TRANSPARENT
        }
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, filter)

        recyclerView = findViewById(R.id.rv_tag)
        toolbar = findViewById(R.id.toolbar)
        collapsingToolBar = findViewById(R.id.collapsingToolbar)
        image = findViewById(R.id.image)
        textView = findViewById(R.id.tag_text_view)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val position = intent.getIntExtra("position", 0)
        init(position)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolBar.title = tagName
        textView.text = tagName
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(networkChangeReceiver)
    }

    //根据点击的分类显示相应的界面
    private fun init(id: Int) {
        when (id) {
            0 -> {
                viewModel.setDisposable(0)
                adLiveData =
                    viewModel.getAdData() as MutableLiveData<MutableList<Advertisement.Item>>
                adLiveData.observe(this, Observer { list ->
                    val adapter = AdAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "广告"
            }

            1 -> {
                viewModel.setDisposable(1)
                exeLiveData = viewModel.getExeData() as MutableLiveData<MutableList<Exercise.Item>>
                exeLiveData.observe(this, Observer { list ->
                    val adapter = ExeAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "运动"
            }

            2 -> {
                viewModel.setDisposable(2)
                musicLiveData = viewModel.getMusicData() as MutableLiveData<MutableList<Music.Item>>
                musicLiveData.observe(this, Observer { list ->
                    val adapter = MusicAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "音乐"
            }

            3 -> {
                viewModel.setDisposable(3)
                dramaLiveData = viewModel.getDramaData() as MutableLiveData<MutableList<Drama.Item>>
                dramaLiveData.observe(this, Observer { list ->
                    val adapter = DramaAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "剧情"
            }

            4 -> {
                viewModel.setDisposable(4)
                funnyLiveData = viewModel.getFunnyData() as MutableLiveData<MutableList<Funny.Item>>
                funnyLiveData.observe(this, Observer { list ->
                    val adapter = FunnyAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "搞笑"
            }

            5 -> {
                viewModel.setDisposable(5)
                foodLiveData = viewModel.getFoodData() as MutableLiveData<MutableList<Food.Item>>
                foodLiveData.observe(this, Observer { list ->
                    val adapter = FoodAdapter(list)
                    recyclerView.adapter = adapter
                })
                tagName = "美食"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}