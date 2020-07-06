package com.example.showingpost

import com.example.showingpost.response_model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun fetchPosts(): Response<PostResponse>

}