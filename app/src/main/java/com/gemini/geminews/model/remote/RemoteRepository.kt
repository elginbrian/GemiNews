package com.gemini.geminews.model.remote

import com.gemini.geminews.model.remote.gemini.GeminiAPI
import com.gemini.geminews.model.remote.news.NewsAPI
import com.gemini.geminews.model.remote.news.Response.GetNewsResponse
import com.gemini.geminews.util.Constant
import com.google.ai.client.generativeai.type.GenerateContentResponse
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val geminiAPI: GeminiAPI, private val newsAPI: NewsAPI) {
    suspend fun callGemini(prompt: String): GenerateContentResponse{
        return geminiAPI.callGemini(prompt)
    }

    suspend fun getUSNews(): GetNewsResponse{
        return newsAPI.getUSNews(Constant.NEWS_KEY)
    }

    suspend fun getIDNews(): GetNewsResponse{
        return newsAPI.getIDNews(Constant.NEWS_KEY)
    }
}