package com.test.module.square

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlin.properties.Delegates

class TagActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adLiveData: MutableLiveData<MutableList<Advertisement.Item>>
    private lateinit var exeLiveData: MutableLiveData<MutableList<Exercise.Item>>
    private lateinit var musicLiveData: MutableLiveData<MutableList<Music.Item>>
    private lateinit var dramaLiveData: MutableLiveData<MutableList<Drama.Item>>
    private lateinit var funnyLiveData: MutableLiveData<MutableList<Funny.Item>>
    private lateinit var foodLiveData: MutableLiveData<MutableList<Food.Item>>
    private lateinit var tagName:String
    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolBar:CollapsingToolbarLayout
    private lateinit var image:ImageView
    var imageID:Int=0

    private val viewModel by lazy { ViewModelProvider(this).get(TagViewModel::class.java)  }
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
        recyclerView = findViewById(R.id.rv_tag)
        toolbar=findViewById(R.id.toolbar)
        collapsingToolBar=findViewById(R.id.collapsingToolbar)
        image=findViewById(R.id.image)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val position=intent.getIntExtra("position",0)
        init(position)
        imageID=intent.getIntExtra("imageID",0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolBar.title=tagName
        Glide.with(this).load(imageID).into(image)
    }

    private fun init(id:Int){
        when (id) {
            0 -> {
                viewModel.setDisposable(0)
                adLiveData=viewModel.getAdData() as MutableLiveData<MutableList<Advertisement.Item>>
                adLiveData.observe(this, Observer { list->
                    val adapter=AdAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="广告"
            }
            1 -> {
                viewModel.setDisposable(1)
                exeLiveData=viewModel.getExeData() as MutableLiveData<MutableList<Exercise.Item>>
                exeLiveData.observe(this, Observer { list->
                    val adapter=ExeAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="运动"
            }
            2 -> {
                viewModel.setDisposable(2)
                musicLiveData=viewModel.getMusicData() as MutableLiveData<MutableList<Music.Item>>
                musicLiveData.observe(this, Observer { list->
                    val adapter=MusicAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="音乐"
            }
            3 -> {
                viewModel.setDisposable(3)
                dramaLiveData=viewModel.getDramaData() as MutableLiveData<MutableList<Drama.Item>>
                dramaLiveData.observe(this, Observer { list->
                    val adapter=DramaAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="剧情"
            }
            4 -> {
                viewModel.setDisposable(4)
                funnyLiveData=viewModel.getFunnyData() as MutableLiveData<MutableList<Funny.Item>>
                funnyLiveData.observe(this, Observer { list->
                    val adapter=FunnyAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="搞笑"
            }
            5 -> {
                viewModel.setDisposable(5)
                foodLiveData=viewModel.getFoodData() as MutableLiveData<MutableList<Food.Item>>
                foodLiveData.observe(this, Observer { list->
                    val adapter=FoodAdapter(list)
                    recyclerView.adapter=adapter
                })
                tagName="开胃"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}