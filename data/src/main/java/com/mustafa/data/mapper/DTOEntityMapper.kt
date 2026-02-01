package com.mustafa.data.mapper

import com.mustafa.data.model.CommentDTO
import com.mustafa.domain.entity.Comment
import com.mustafa.domain.entity.User

fun CommentDTO.toCommentEntity() : Comment{
    return Comment(id, body, User(userDTO.id,userDTO.username,userDTO.fullName))
}