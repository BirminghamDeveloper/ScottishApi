package com.Mustafa.scottishapi.screens.comments

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.domain.use_cases.comments.CommentUseCases
import com.mustafa.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val commentsUseCases : CommentUseCases,
) : ViewModel() {
    private val _commentsUiState = mutableStateOf(CommentUIState())
    val commentsUiState : State<CommentUIState> = _commentsUiState

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    init {
        fetchComments()
    }

    fun onSearchQueryChange(query: String){
        _searchQuery.value = query
    }

    fun fetchComments() {
        viewModelScope.launch {
            commentsUseCases.getAllCommentsUseCase().collect { result ->
                _commentsUiState.value = when(result) {
                    is Resource.Loading -> _commentsUiState.value.copy(isLoading = true)
                    is Resource.Success -> {
                        _commentsUiState.value.copy(
                            isLoading = false,
                            comments = result.data ?: emptyList(),
                            error = null
                        )
                    }

                    is Resource.Failure -> _commentsUiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                    else -> _commentsUiState.value.copy(isLoading = false)
                }
            }
        }
    }
}