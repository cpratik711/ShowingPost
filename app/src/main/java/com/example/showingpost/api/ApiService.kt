package com.example.showingpost

import com.example.showingpost.db_model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun fetchPosts(): Response<List<Post>>

}