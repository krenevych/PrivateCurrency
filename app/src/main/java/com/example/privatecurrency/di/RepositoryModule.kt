package com.example.privatecurrency.di

import com.example.privatecurrency.data.repository.RepositoryImpl
import com.example.privatecurrency.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bingRepository(
        repository: RepositoryImpl
    ): Repository
}