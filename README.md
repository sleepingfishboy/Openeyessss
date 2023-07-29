# Openeyessss
 暑假考核
 ## APP简要介绍
 这是一个用来刷视频的APP，可以看视频，背景是优美的粉色到淡紫色的渐变，点开不同页面的视频都可以跳转到一个视频播放界面，在这里，有视频的简介，下面还有推荐的相关视频，还可以查看评论转发下载，本来想添加点赞收藏的，但由于本人水平和时间有限，没能完成，很遗憾。
 ## 在团队里所做的工作
 我负责了排行、我的和视频播放界面以及网络请求和粉色的UI,由于时间关系和个人能力原因"我的"界面极为简略。
 ### 实现的功能
![18dbcb6847ce02031f06db309e962c82](https://github.com/sleepingfishboy/Openeyessss/assets/113912189/e4e2dc0e-17a4-4857-aeb1-255f0cdca372)

![18dbcb6847ce02031f06db309e962c82](https://github.com/sleepingfishboy/Openeyessss/assets/113912189/e760a39f-86e1-48ad-8c52-0747e093a8ea)

![8702a1f12fc3b5ccabe3685cf8fe9945](https://github.com/sleepingfishboy/Openeyessss/assets/113912189/993e9d98-9d0b-49cc-83d1-873751a2ac45)


### 使用到的比较重要的技术及知识点
 使用了rxjava retrofit进行网络请求，用DownloadManager下载视频，使用了cardview包裹控件，使界面更好看。用dkVidaoPlayer实现播放视频的功能，用了NestedScrowView嵌套textview和recyclerView实现嵌套滑动实现视频介绍点赞和视频推荐。用BottomSheetDialogFragment实现评论，在没有数据时显示没有评论。开眼app的视频播放界面背景是黑色的，但我个人觉得，并不是很好看，但如果是白色又太单调，看见苟云东和李伊侗他们组的音乐播放是粉色的，觉得十分好看就借用了过来，然后全局部署。cardview十分好看，基本上所有的控件都用card包裹，感谢苟云东和钟栋提供的灵感。


### 不足之处

+ “我的”界面十分简略，没有实现任何功能
+ 评论的接口有些抽象，界面很多都是空的。
  
  

### 心得体会

