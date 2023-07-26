package com.test.module.player

class CommentBean(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int
) {
    class Item(

        val `data`: Data,
        val id: Int,

    ) {
        class Data(
            val actionUrl: Any,
            val adTrack: Any,
            val cover: Any,
            val createTime: Long,
            val dataType: String,
            val font: String,
            val hot: Boolean,
            val id: Long,
            val imageUrl: String,
            val likeCount: Int,
            val liked: Boolean,
            val message: String,
            val parentReply: ParentReply,
            val parentReplyId: Long,
            val recommendLevel: String,
            val replyStatus: String,
            val rootReplyId: Long,
            val sequence: Int,
            val showConversationButton: Boolean,
            val showParentReply: Boolean,
            val sid: String,
            val text: String,
            val type: String,
            val ugcVideoId: Any,
            val ugcVideoUrl: Any,
            val user: User,
            val userBlocked: Boolean,
            val userType: Any,
            val videoId: Int,
            val videoTitle: String
        ) {
            class ParentReply(
                val id: Long,
                val imageUrl: Any,
                val message: String,
                val replyStatus: String,
                val user: User
            ) {
                class User(
                    val actionUrl: String,
                    val area: Any,
                    val avatar: String,

                    val city: Any,
                    val country: Any,
                    val cover: String,
                    val description: Any,
                    val expert: Boolean,
                    val followed: Boolean,
                    val gender: Any,
                    val ifPgc: Boolean,
                    val job: Any,
                    val library: String,
                    val limitVideoOpen: Boolean,
                    val nickname: String,
                    val registDate: Long,
                    val releaseDate: Any,
                    val uid: Int,
                    val university: Any,
                    val userType: String
                )
            }

            class User(
                val actionUrl: String,
                val area: Any,
                val avatar: String,
                val birthday: Int,
                val city: String,
                val country: String,
                val cover: String,
                val description: String,
                val expert: Boolean,
                val followed: Boolean,
                val gender: String,
                val ifPgc: Boolean,
                val job: String,
                val library: String,
                val limitVideoOpen: Boolean,
                val nickname: String,
                val registDate: Long,
                val releaseDate: Long,
                val uid: Int,
                val university: String,
                val userType: String
            )
        }
    }
}