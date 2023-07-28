# Openeyessss
 暑假考核
# 开眼视频

## APP简要介绍

这个APP是基于开眼APP进行的仿写，主要功能是推荐优质视频内容和每日新鲜资讯。

它的使用步骤大致是：在APP里浏览视频的大致内容，看到感兴趣的内容就点击进去，即可进入视频播放界面观看视频。

## 在团队里所做的工作

### 所负责的模块

我主要负责的是app、module_home、module_square模块

### 实现的功能

我实现的功能有底部导航栏，tab栏，推荐界面和日报界面，广场界面的Carousel展示分类，广场分类界面中的折叠标题栏，ARouter的使用

+ 推荐界面

  ![QQ图片20230728211239](https://github.com/sleepingfishboy/Openeyessss/assets/119737732/e2b72253-eed4-46ab-9515-69c8c8c0ad86)

+ 日报界面

  ![QQ图片20230728211310](https://github.com/sleepingfishboy/Openeyessss/assets/119737732/80a85399-d006-41d5-a667-6ceba7da4fd0)


+ 广场界面

  ![QQ图片20230728211322](https://github.com/sleepingfishboy/Openeyessss/assets/119737732/af48f4ec-dc56-411c-b927-4d6b7801013b)


### 使用到的比较重要的技术及知识点

整个APP的大体框架是Navigation和BottomNavigationView的结合，首页、广场、排行、我的这四个页面是四个Fragment，放在了一个Navigation Graph中。

首页是TabLayout、ViewPager2、RecyclerView的结合使用。在推荐界面使用了Paging3（~~虽说用处不大~~）。界面中用来显示封面和标题的都是一个CardView。

广场的分类是用Carousel组件实现的(看着很花哨)，点进去一个分类，页面是一个折叠式标题栏加上RecyclerView。

模块间通信用的是ARouter(只是简单使用)。

知识点：Navigation,ViewModel,LiveData,Paging3,ViewPager2,TabLayout,RecyclerView,CardView,Carousel,CollapsingToolbarLayout,BottomNavigationView,SwipeRefreshLayout,ARouter...

### 不足之处

+ 界面和结构比较单一。
+ 接口处理的不太好，推荐界面就那么几个视频。
+ 下拉加载/刷新效果不太好
+ 广场界面太空旷，实在想不到写啥了

### 心得体会

多人开发与单人开发不同的是，需要明确每个人的分工，并使用多模块开发以及模块间通信。不过也体验到了多人开发的高效，当我达不到我想要的效果时，我的搭档会给我帮助。

通过仿写一个APP,我感受到了做出一个美观好用的APP的困难。但当我实现了一个功能后，也会感受到兴奋。
