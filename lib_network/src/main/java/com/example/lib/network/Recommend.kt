package com.example.lib.network

class Recommend(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
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
            val count: Int,
            val cover: Cover,
            val dataType: String,
            val date: Long,
            val description: String,
            val descriptionEditor: String,
            val descriptionPgc: String,
            val duration: Int,
            val favoriteAdTrack: Any,
            val follow: Any,
            val footer: Any,
            val header: Header,
            val id: Int,
            val idx: Int,
            val ifLimitVideo: Boolean,
            val itemList: List<Item>,
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
            val subTitle: Any,
            val subtitles: List<Any>,
            val tags: List<Tag>,
            val text: String,
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

            class Content(
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
                    val slogan: String,
                    val src: Int,
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
                        val homepage: String,
                        val sharing: Any
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

            class Cover(
                val blurred: String,
                val detail: String,
                val feed: String,
                val homepage: String,
                val sharing: Any
            )

            class Header(
                val actionUrl: String,
                val cover: Any,
                val description: String,
                val font: String,
                val icon: String,
                val iconType: String,
                val id: Int,
                val label: Any,
                val labelList: Any,
                val rightText: String,
                val showHateVideo: Boolean,
                val subTitle: String,
                val subTitleFont: String,
                val textAlign: String,
                val time: Long,
                val title: String
            )

            class Item(
                val adIndex: Int,
                val `data`: Data,
                val id: Int,
                val tag: Any,
                val trackingData: Any,
                val type: String
            ) {
                class Data(
                    val adTrack: List<Any>,
                    val content: Content,
                    val dataType: String,
                    val header: Header
                ) {
                    class Content(
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
                            val recallSource: Any,
                            val recall_source: Any,
                            val releaseTime: Long,
                            val remark: String,
                            val resourceType: String,
                            val searchWeight: Int,
                            val shareAdTrack: Any,
                            val slogan: Any,
                            val src: Any,
                            val subtitles: List<Any>,
                            val tags: List<Tag>,
                            val thumbPlayUrl: Any,
                            val title: String,
                            val titlePgc: String,
                            val type: String,
                            val videoPosterBean: Any,
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
                                val homepage: String,
                                val sharing: Any
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

                            class WebUrl(
                                val forWeibo: String,
                                val raw: String
                            )
                        }
                    }

                    class Header(
                        val actionUrl: String,
                        val cover: Any,
                        val description: Any,
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
                }
            }

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