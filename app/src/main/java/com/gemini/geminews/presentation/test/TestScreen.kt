package com.gemini.geminews.presentation.test

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gemini.geminews.model.remote.news.Response.GetNewsResponse

@Composable
fun TestScreen(viewModel: TestViewModel){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        var result  = remember { mutableStateOf("") }
        var result2 = remember { mutableStateOf<GetNewsResponse?>(GetNewsResponse(status = "", totalResults = 0, articles = emptyList())) }

        Button(onClick = {
            result.value = viewModel.callGemini("Hello There!")?.text.toString()
            Log.d("TestScreen", result.value)
        }) { Text(text = "Hello There!")}

        Button(onClick = {
            result2.value = viewModel.getNews()
            Log.d("TestScreen", result2.value.toString())
        }) { Text(text = "Get News")}

        Text(text = result.value)
        if(result2.value?.articles?.isNotEmpty() == true){
            result2.value?.articles?.get(0)?.let { Text(text = it.toString()) }
        }
    }
}