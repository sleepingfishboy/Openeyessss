package com.test.module.square

data class Exercise(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int
){

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Data(
    val adTrack: List<Any>,
    val content: Content,
    val dataType: String,
    val header: Header
)

data class Content(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Header(
    val actionUrl: String,
    val cover: Any,
    val description: String,
    val font: Any,
    val icon: String,
    val iconType: String,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: Any,
    val showHateVideo: Boolean,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val time: Long,
    val title: String
)

data class DataX(
    val ad: Boolean,
    val adTrack: List<Any>,
    val areaSet: List<Any>,
    val author: Author,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val candidateId: Int,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val cover: Cover,
    val createTime: Long,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: String,
    val duration: Int,
    val favoriteAdTrack: Any,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val infoStatus: String,
    val label: Any,
    val labelList: List<Any>,
    val lastViewTime: Any,
    val library: String,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val premiereDate: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val recall_source: Any,
    val releaseTime: Long,
    val remark: String,
    val resourceType: String,
    val searchWeight: Int,
    val shareAdTrack: Any,
    val showLabel: Boolean,
    val slogan: String,
    val sourceUrl: String,
    val src: Any,
    val status: String,
    val subtitleStatus: String,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val tailTimePoint: Int,
    val thumbPlayUrl: String,
    val title: String,
    val titlePgc: String,
    val translateStatus: String,
    val type: String,
    val updateTime: Long,
    val videoPosterBean: VideoPosterBean,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)

data class Author(
    val adTrack: Any,
    val amplifiedLevelId: Int,
    val approvedNotReadyVideoCount: Int,
    val authorStatus: String,
    val authorType: String,
    val cover: String,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val library: String,
    val link: String,
    val name: String,
    val pendingVideoCount: Int,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val playCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: String,
    val sharing: Any
)

data class PlayInfo(
    val bitRate: Int,
    val dimension: String,
    val duration: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val size: Int,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val videoId: Int,
    val width: Int
)

data class Provider(
    val alias: String,
    val icon: String,
    val id: Int,
    val name: String,
    val status: String
)

data class Tag(
    val actionUrl: String,
    val adTrack: Any,
    val alias: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: String,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val ifShow: Boolean,
    val level: Int,
    val name: String,
    val newestEndTime: Any,
    val parentId: Int,
    val recWeight: Double,
    val relationType: Int,
    val tagRecType: String,
    val tagStatus: String,
    val top: Int,
    val type: String
)

data class VideoPosterBean(
    val fileSizeStr: String,
    val scale: Double,
    val url: String
)

data class WebUrl(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)

data class Url(
    val name: String,
    val size: Int,
    val url: String
)}