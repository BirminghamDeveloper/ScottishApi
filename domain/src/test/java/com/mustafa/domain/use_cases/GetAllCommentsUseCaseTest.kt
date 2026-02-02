package com.mustafa.domain.use_cases

import com.mustafa.domain.repositories.comment.CommentRepository
import com.mustafa.domain.use_cases.comments.GetAllCommentsUseCase
import com.mustafa.domain.utils.Resource
import com.mustafa.domain.entity.Comment
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAllCommentsUseCaseTest {

    private val repository: CommentRepository = mockk()

    private val useCase = GetAllCommentsUseCase(repository)

    @Test
    fun `invoke should return list of comments from repository`() = runTest {
        // Arrange: Create a fake list of domain comments

        val mockComments = listOf(
            Comment(id = 1, body = "Test 1", name = "Mustafa", email = "mustafa2@gmail.com"),
            Comment(id = 2, body = "Test 2", name = "Mustafa2", email = "mustafa2@gmail.com")
        )
        
        // "Train" the mock: When repo.getAllComments() is called, return our fake list
        coEvery { repository.getAllComments() } returns flowOf(Resource.Success(mockComments))

        // Act: Call the use case
        val resultFlow = useCase()

        // Assert: Collect the flow and check the data
        resultFlow.collect { resource ->
            assert(resource is Resource.Success)
            assertEquals(mockComments, (resource as Resource.Success).data)
        }
        
        // Verify the repository was actually called exactly once
        coVerify(exactly = 1) { repository.getAllComments() }
    }
}