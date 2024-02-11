package com.gemini.geminews.model.remote.news

import com.gemini.geminews.model.remote.news.Response.GetNewsResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsAPI {
    @GET("top-headlines?country=us")
    suspend fun getUSNews(
        @Header("Authorization") newsKey: String
    ): GetNewsResponse

    @GET("top-headlines?country=id")
    suspend fun getIDNews(
        @Header("Authorization") newsKey: String
    ): GetNewsResponse
}