package com.mustafa.data.mapper

import com.mustafa.data.model.CommentDTO
import com.mustafa.domain.entity.Comment

fun CommentDTO.toCommentEntity() : Comment{
    return Comment(id, name, email, body)
}