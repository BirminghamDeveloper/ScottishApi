package com.mustafa.data.utils

import com.mustafa.data.model.CommentDTO
import com.mustafa.domain.entity.Comment

object MockData {

    val mockCommentDTO = CommentDTO(
        id = 1,
        body = "This is a clean architecture test.",
        email = "Mustafa2@gmail.com",
        name = "Mustafa"
    )


    val mockDomainComment = Comment(
        id = 1,
        body = "This is a clean architecture test.",
        email = "Mustafa2@gmail.com",
        name = "Mustafa"
    )
}