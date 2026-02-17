package com.Mustafa.scottishapi.screens.comments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.Mustafa.scottishapi.screens.comments.components.CommentItem
import androidx.compose.ui.Alignment.Companion.Center


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentsScreen(
    modifier: Modifier = Modifier,
    viewModel: CommentViewModel,
    onCommentClick : (id : Int) -> Unit
) {


    val commentsUiState = viewModel.commentsUiState

    val searchQuery by viewModel.searchQuery
    val filterComent = remember(searchQuery, commentsUiState.value.comments) {
        commentsUiState.value.comments.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    }

    if(commentsUiState.value.isLoading){
        Box(
            modifier.fillMaxSize()
        ){
            CircularProgressIndicator(
                modifier = Modifier.align(Center)
            )
        }
    }else{
        Scaffold(
            topBar = {
                Column{
                    TopAppBar(
                        title = { Text("Comments Screen", fontSize = 18.sp, fontWeight = FontWeight.Bold) }
                    )
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { viewModel.onSearchQueryChange(it) },
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                        placeholder = {
                            Text("seach for comments")
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "Searching Icons")
                        },
                        shape = RoundedCornerShape(12.dp)
                    )
                }

            },
            containerColor = Color(0xFFF7F7F7)
        ) { padding ->
            if(commentsUiState.value.error == null){
                val comments = commentsUiState.value.comments
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(comments) { _, comment ->
                        CommentItem(
                            comment = comment,
                            onCommentClick = {
                                onCommentClick(comment.id)
                            }
                        )
                    }
                }
            }else{
                Box(
                    modifier.fillMaxSize()
                ){
                    Text(
                        text = "Something went wrong : " + commentsUiState.value.error,
                        modifier = Modifier.align(Center)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun PreviewCommentsScreen() {

}