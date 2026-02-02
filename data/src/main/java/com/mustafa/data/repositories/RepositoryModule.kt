package com.mustafa.data.repositories

import com.mustafa.domain.repositories.comment.CommentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideCommentRepository(repositoryImpl: CommentRepositoryImpl) : CommentRepository
}