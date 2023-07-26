package com.test.module.home

import android.accounts.AuthenticatorDescription

data class RecommendResponse(val itemList: List<Item>) {
    data class Item(val `data`: Data, val id: Int)
    data class Data(val author: Author, val cover: Cover, val title: String, val playUrl: String,val description: String,val id: Int)
    data class Author(val name: String)
    data class Cover(val detail: String)
}