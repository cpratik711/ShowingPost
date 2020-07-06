package com.example.showingpost.response_model


import com.example.showingpost.db_model.Post

data class PostResponse(
    val results : List<Post>
)