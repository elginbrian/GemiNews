package com.gemini.geminews.di

import com.gemini.geminews.model.remote.RemoteRepository
import com.gemini.geminews.model.remote.gemini.GeminiAPI
import com.gemini.geminews.model.remote.news.NewsAPI
import com.gemini.geminews.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRemoteRepository(geminiAPI: GeminiAPI, newsAPI: NewsAPI): RemoteRepository {
        return RemoteRepository(geminiAPI, newsAPI)
    }

    @Singleton
    @Provides
    fun provideGeminiAPI(): GeminiAPI {
        return GeminiAPI()
    }

    @Singleton
    @Provides
    fun provideNewsAPI(): NewsAPI{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }
}