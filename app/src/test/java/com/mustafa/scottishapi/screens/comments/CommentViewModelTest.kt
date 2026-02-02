package com.mustafa.scottishapi.screens.comments


import com.Mustafa.scottishapi.screens.comments.CommentViewModel
import com.mustafa.scottishapi.utils.MainDispatcherRule
import com.mustafa.domain.entity.Comment
import com.mustafa.domain.use_cases.comments.CommentUseCases
import com.mustafa.domain.use_cases.comments.GetAllCommentsUseCase
import com.mustafa.domain.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CommentViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getAllCommentsUseCase: GetAllCommentsUseCase = mockk()

    private val useCases = CommentUseCases(getAllCommentsUseCase)
    
    private lateinit var viewModel: CommentViewModel

    @Test
    fun `init should load comments and update state to Success`() = runTest {
        // Arrange
        val mockComments = listOf(
            Comment(id = 1, body = "UI Test", email = "mustafa@gmail.com", name = "mustafa")
        )

        coEvery { getAllCommentsUseCase() } returns flowOf(Resource.Success(mockComments))

        // Act
        viewModel = CommentViewModel(useCases)

        // Assert
        val state = viewModel.commentsUiState.value

        assertFalse("Loading should be false", state.isLoading)
        assertNull("Error should be null", state.error)
        assertEquals("Comments list should match", mockComments, state.comments)
    }

    @Test
    fun `fetchComments should update state with Error message on failure`() = runTest {
        // Arrange
        val errorMessage = "Network Connection Failed"

        coEvery { getAllCommentsUseCase() } returns flowOf(Resource.Failure(errorMessage))

        // Act
        viewModel = CommentViewModel(useCases)

        // Assert
        val state = viewModel.commentsUiState.value

        assertFalse("Loading should be false", state.isLoading)
        assertEquals("Error message should match", errorMessage, state.error)
        assertEquals("Comments should be empty", emptyList<Comment>(), state.comments)
    }

    @Test
    fun `fetchComments should show loading initially`() = runTest {
        // Arrange
        val mockComments = listOf(Comment(id = 1, body = "Body", email = "mustafa@gmail.com", name = "mustafa"))

        // We simulate the sequence of events: Loading -> Success
        coEvery { getAllCommentsUseCase() } returns flowOf(
            Resource.Loading(),
            Resource.Success(mockComments)
        )

        // Act
        viewModel = CommentViewModel(useCases)

        val state = viewModel.commentsUiState.value
        assertEquals(mockComments, state.comments)
        assertFalse(state.isLoading)
    }
}