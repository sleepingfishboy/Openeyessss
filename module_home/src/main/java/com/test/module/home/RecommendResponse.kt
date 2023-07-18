package com.test.module.home

data class RecommendResponse(val itemList: List<Item>) {
    data class Item(val `data`: Data, val id: Int,)
    data class Data(val author: Author, val cover: Cover,val title: String)
    data class Author(val name: String)
    data class Cover(val detail: String)
}