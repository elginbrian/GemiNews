package com.gemini.geminews.presentation.chatscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gemini.geminews.model.remote.RemoteRepository
import com.gemini.geminews.model.remote.news.Response.GetNewsResponse
import com.google.ai.client.generativeai.type.GenerateContentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor(private val remoteRepository: RemoteRepository): ViewModel(){
    private val _testGeminiState     = mutableStateOf<GenerateContentResponse?>(null)
    private val _testGetNewsResponse = mutableStateOf<GetNewsResponse?>(null)

    fun callGemini(prompt: String): GenerateContentResponse? {
        viewModelScope.launch {
            _testGeminiState.value = remoteRepository.callGemini(prompt)
        }
        return _testGeminiState.value
    }

    fun getNews(): GetNewsResponse? {
        viewModelScope.launch {
            _testGetNewsResponse.value = remoteRepository.getUSNews()
        }
        return _testGetNewsResponse.value
    }
}