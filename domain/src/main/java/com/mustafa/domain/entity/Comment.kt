package com.mustafa.domain.entity

data class Comment(
    val id: Int,
    val body: String,
    val user : User
)