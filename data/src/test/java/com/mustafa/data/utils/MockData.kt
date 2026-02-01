package com.mustafa.data.utils

import com.mustafa.data.model.CommentDTO
import com.mustafa.data.model.UserDTO
import com.mustafa.domain.entity.Comment
import com.mustafa.domain.entity.User

object MockData {

    val mockUserDTO = UserDTO(
        id = 99,
        username = "Mustafa-Development123",
        fullName = "Mustafa Sharif"
    )

    val mockCommentDTO = CommentDTO(
        id = 1,
        body = "This is a clean architecture test.",
        userDTO = mockUserDTO
    )

    val mockDomainUser = User(
        id = 99,
        username = "Mustafa-Development123",
        fullName = "Mustafa Sharif"
    )

    val mockDomainComment = Comment(
        id = 1,
        body = "This is a clean architecture test.",
        user = mockDomainUser
    )
}