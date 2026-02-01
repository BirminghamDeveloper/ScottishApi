package com.mustafa.domain.repositories.comment

import com.mustafa.domain.entity.Comment
import com.mustafa.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun getAllComments() : Flow<Resource<List<Comment>>>
}