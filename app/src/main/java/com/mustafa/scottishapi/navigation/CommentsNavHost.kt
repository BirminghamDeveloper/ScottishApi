package com.Mustafa.scottishapi.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.Mustafa.scottishapi.screens.comments.CommentsDetailsScreen
import com.Mustafa.scottishapi.screens.comments.CommentViewModel
import com.Mustafa.scottishapi.screens.comments.CommentsScreen

@Composable
fun CommentsNavHost(){
    val navController = rememberNavController()
    val commentsViewModel : CommentViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Route.CommentsScreen.name){
        composable(
            route = Route.CommentsScreen.name,
        ){
            CommentsScreen(
                viewModel = commentsViewModel,
                onCommentClick = { index ->
                    navController.navigate("${Route.CommentsDetailsScreen.name}/$index")
                }
            )
        }

        composable(
            route = Route.CommentsDetailsScreen.name+ "/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ){ backStackEntry ->
            val comments = commentsViewModel.commentsUiState.value.comments
            val index = backStackEntry.arguments?.getInt("index") ?: 0

            if (index in comments.indices) {
                CommentsDetailsScreen(
                    comment = comments[index],
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            } else {
                Text("Comment not found")
            }
        }
    }
}