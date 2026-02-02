package com.Mustafa.scottishapi.screens.comments

import com.mustafa.domain.entity.Comment

data class CommentUIState(
    val comments : List<Comment> = emptyList(),
    val isLoading : Boolean = false,
    val error : String? = null
)
