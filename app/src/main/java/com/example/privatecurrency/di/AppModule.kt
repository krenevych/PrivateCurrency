package com.example.privatecurrency.di

import com.example.privatecurrency.data.repository.RepositoryImpl
import com.example.privatecurrency.data.retrofit.ServicePrivate
import com.example.privatecurrency.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideService() : ServicePrivate {
        val BASE_URL = "https://api.privatbank.ua/"  // обовʼязково закінчується слешем '/'

        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServicePrivate::class.java)

        return service
    }

    @Provides
    @Singleton
    fun provideRepository(service: ServicePrivate) : Repository {
        return RepositoryImpl(service )
    }

}