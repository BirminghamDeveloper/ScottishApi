package com.mustafa.domain.use_cases.comments

import com.mustafa.domain.entity.Comment
import com.mustafa.domain.repositories.comment.CommentRepository
import com.mustafa.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCommentsUseCase(
    private val commentRepository: CommentRepository
){
    operator fun invoke() : Flow<Resource<List<Comment>>>{
        return commentRepository.getAllComments()
    }
}