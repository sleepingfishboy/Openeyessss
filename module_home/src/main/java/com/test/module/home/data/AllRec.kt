package com.test.module.home.data

data class AllRec(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int
) {

    data class Item(
        val adIndex: Int,
        val `data`: Data,
        val id: Int,
        val tag: Any,
        val trackingData: Any,
        val type: String
    )

    data class Data(
        val actionUrl: String,
        val ad: Boolean,
        val adTrack: List<Any>,
        val author: Author,
        val brandWebsiteInfo: Any,
        val campaign: Any,
        val category: String,
        val collected: Boolean,
        val consumption: Consumption,
        val content: Content,
        val cover: CoverX,
        val dataType: String,
        val date: Long,
        val description: String,
        val descriptionEditor: String,
        val descriptionPgc: Any,
        val duration: Int,
        val favoriteAdTrack: Any,
        val follow: Any,
        val header: Header,
        val id: Int,
        val idx: Int,
        val ifLimitVideo: Boolean,
        val label: Any,
        val labelList: List<Any>,
        val lastViewTime: Any,
        val library: String,
        val playInfo: List<PlayInfoX>,
        val playUrl: String,
        val played: Boolean,
        val playlists: Any,
        val promotion: Any,
        val provider: ProviderX,
        val reallyCollected: Boolean,
        val recallSource: String,
        val recall_source: String,
        val releaseTime: Long,
        val remark: String,
        val resourceType: String,
        val searchWeight: Int,
        val shareAdTrack: Any,
        val slogan: Any,
        val src: Int,
        val subTitle: Any,
        val subtitles: List<Any>,
        val tags: List<TagX>,
        val text: String,
        val thumbPlayUrl: Any,
        val title: String,
        val titlePgc: Any,
        val type: String,
        val videoPosterBean: VideoPosterBeanX,
        val waterMarks: Any,
        val webAdTrack: Any,
        val webUrl: WebUrlX
    )

    data class Author(
        val adTrack: Any,
        val approvedNotReadyVideoCount: Int,
        val description: String,
        val expert: Boolean,
        val follow: Follow,
        val icon: String,
        val id: Int,
        val ifPgc: Boolean,
        val latestReleaseTime: Long,
        val link: String,
        val name: String,
        val recSort: Int,
        val shield: Shield,
        val videoNum: Int
    )

    data class Consumption(
        val collectionCount: Int,
        val realCollectionCount: Int,
        val replyCount: Int,
        val shareCount: Int
    )

    data class Content(
        val adIndex: Int,
        val `data`: DataX,
        val id: Int,
        val tag: Any,
        val trackingData: Any,
        val type: String
    )

    data class CoverX(
        val blurred: String,
        val detail: String,
        val feed: String,
        val homepage: Any,
        val sharing: Any
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

    data class PlayInfoX(
        val height: Int,
        val name: String,
        val type: String,
        val url: String,
        val width: Int
    )

    data class ProviderX(
        val alias: String,
        val icon: String,
        val name: String
    )

    data class TagX(
        val actionUrl: String,
        val adTrack: Any,
        val bgPicture: String,
        val childTagIdList: Any,
        val childTagList: Any,
        val communityIndex: Int,
        val desc: String,
        val haveReward: Boolean,
        val headerImage: String,
        val id: Int,
        val ifNewest: Boolean,
        val name: String,
        val newestEndTime: Any,
        val tagRecType: String
    )

    data class VideoPosterBeanX(
        val fileSizeStr: String,
        val scale: Double,
        val url: String
    )

    data class WebUrlX(
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

    data class DataX(
        val ad: Boolean,
        val adTrack: List<Any>,
        val author: AuthorX,
        val brandWebsiteInfo: Any,
        val campaign: Any,
        val category: String,
        val collected: Boolean,
        val consumption: Consumption,
        val cover: Cover,
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
        val label: Any,
        val labelList: List<Any>,
        val lastViewTime: Any,
        val library: String,
        val playInfo: List<PlayInfo>,
        val playUrl: String,
        val played: Boolean,
        val playlists: Any,
        val promotion: Any,
        val provider: Provider,
        val reallyCollected: Boolean,
        val recallSource: String,
        val recall_source: String,
        val releaseTime: Long,
        val remark: String,
        val resourceType: String,
        val searchWeight: Int,
        val shareAdTrack: Any,
        val slogan: Any,
        val src: Int,
        val subtitles: List<Any>,
        val tags: List<Tag>,
        val thumbPlayUrl: Any,
        val title: String,
        val titlePgc: String,
        val type: String,
        val waterMarks: Any,
        val webAdTrack: Any,
        val webUrl: WebUrl
    )

    data class AuthorX(
        val adTrack: Any,
        val approvedNotReadyVideoCount: Int,
        val description: String,
        val expert: Boolean,
        val icon: String,
        val id: Int,
        val ifPgc: Boolean,
        val latestReleaseTime: Long,
        val link: String,
        val name: String,
        val recSort: Int,
        val videoNum: Int
    )

    data class PlayInfo(
        val height: Int,
        val name: String,
        val type: String,
        val url: String,
        val urlList: List<Url>,
        val width: Int
    )

    data class Url(
        val name: String,
        val size: Int,
        val url: String
    )
}