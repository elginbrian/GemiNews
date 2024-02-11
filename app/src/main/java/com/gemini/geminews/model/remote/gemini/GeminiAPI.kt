package com.gemini.geminews.model.remote.gemini

import com.gemini.geminews.util.Constant
import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.GenerateContentResponse
import javax.inject.Inject

class GeminiAPI @Inject constructor() {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constant.GEMINI_KEY
    )

    suspend fun callGemini(prompt: String): GenerateContentResponse {
        val response = generativeModel.generateContent(prompt)
        return response
    }
}