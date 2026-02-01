package com.mustafa.data.web_service


import com.mustafa.data.model.CommentResponse
import retrofit2.http.GET

interface CommentApiService {
    @GET("comments")
    suspend fun getComments() : CommentResponse
}