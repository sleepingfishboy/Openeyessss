package com.test.module.discovery.network

/**
 *作者：sleepingfishboy
 *时间：2023/7/19

 */
class Total(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
) {
    class Item(
        val adIndex: Int,
        val `data`: Data,
        val id: Int,
        val tag: Any,
        val trackingData: Any,
        val type: String
    ) {
        class Data(
            val ad: Boolean,
            val adTrack: List<Any>,
            val author: Author,
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
            val label: Label,
            val labelList: List<Label>,
            val lastViewTime: Any,
            val library: String,
            val playInfo: List<PlayInfo>,
            val playUrl: String,
            val played: Boolean,
            val playlists: Any,
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
            val slogan: String,
            val src: Any,
            val subtitles: List<Any>,
            val tags: List<Tag>,
            val thumbPlayUrl: Any,
            val title: String,
            val titlePgc: String,
            val type: String,
            val videoPosterBean: VideoPosterBean,
            val waterMarks: Any,
            val webAdTrack: Any,
            val webUrl: WebUrl
        ) {
            class Author(
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
            ) {
                class Follow(
                    val followed: Boolean,
                    val itemId: Int,
                    val itemType: String
                )

                class Shield(
                    val itemId: Int,
                    val itemType: String,
                    val shielded: Boolean
                )
            }

            class Consumption(
                val collectionCount: Int,
                val realCollectionCount: Int,
                val replyCount: Int,
                val shareCount: Int
            )

            class Cover(
                val blurred: String,
                val detail: String,
                val feed: String,
                val homepage: Any,
                val sharing: Any
            )

            class Label(
                val card: String,
                val detail: String,
                val text1: String,
                val actionUrl: Any,
                val text: String
            )


            class PlayInfo(
                val height: Int,
                val name: String,
                val type: String,
                val url: String,
                val urlList: List<Url>,
                val width: Int
            ) {
                class Url(
                    val name: String,
                    val size: Int,
                    val url: String
                )
            }

            class Provider(
                val alias: String,
                val icon: String,
                val name: String
            )

            class Tag(
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

            class VideoPosterBean(
                val fileSizeStr: String,
                val scale: Double,
                val url: String
            )

            class WebUrl(
                val forWeibo: String,
                val raw: String
            )
        }
    }
}