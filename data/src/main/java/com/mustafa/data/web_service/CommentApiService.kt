package com.mustafa.data.web_service


import com.mustafa.data.model.CommentDTO
import retrofit2.http.GET

interface CommentApiService {
    @GET("comments")
    suspend fun getComments() : List<CommentDTO>
}