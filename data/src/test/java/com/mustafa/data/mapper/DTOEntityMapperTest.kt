package com.mustafa.data.mapper

import com.mustafa.data.utils.MockData
import org.junit.Assert.assertEquals
import org.junit.Test

class DTOEntityMapperTest {



    @Test
    fun `mapToDomain should correctly map nested UserDTO to Domain Entity`() {
        // Arrange
        val dto = MockData.mockCommentDTO
        val expectedDomain = MockData.mockDomainComment

        // Act
        val result = dto.toCommentEntity()

        // Assert
        assertEquals(expectedDomain.id, result.id)
        assertEquals(expectedDomain.body, result.body)

        assertEquals(expectedDomain.name, result.name)
    }
}