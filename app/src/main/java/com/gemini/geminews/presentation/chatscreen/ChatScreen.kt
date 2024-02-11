package com.gemini.geminews.presentation.chatscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gemini.geminews.presentation.chatbubble.ChatRequest
import com.gemini.geminews.presentation.chatbubble.ChatResponse
import com.gemini.geminews.presentation.newscard.NewsCard
import com.gemini.geminews.presentation.textfield.GeminiTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatScreen(viewModel: ChatScreenViewModel){
    var prompt = remember { mutableStateOf("") }
    var promptString  = remember { mutableStateOf("") }
    var responseString = remember { mutableStateOf("") }

    var listOfPrompt = promptString.value.split("|")
    var lisOfResponse = responseString.value.split("|")

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            topBar = {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                    shape = RectangleShape,
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
                ) {

                }
            },
            content = {
                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp)){
                    item {
                        Spacer(modifier = Modifier.padding(45.dp))
                    }
                    items(listOfPrompt.size){
                        if(listOfPrompt[it].isNotEmpty()){
                            ChatRequest(request = listOfPrompt[it])
                        }
                        Spacer(modifier = Modifier.padding(5.dp))

                        if(lisOfResponse[it].isNotEmpty() && !lisOfResponse[it].equals("null")){
                            ChatResponse(response = lisOfResponse[it])
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                    item {
                        Spacer(modifier = Modifier.padding(50.dp))
                    }
                }
            },
            bottomBar = {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                    shape = RectangleShape,
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
                ) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                        GeminiTextField(
                            keyboardType = KeyboardType.Text,
                            text = prompt.value, label = "Prompt",
                            onTextChange = {
                                if ((it.all { char -> char.isDefined() || char.isWhitespace() })) {
                                    prompt.value = it
                                }
                            }
                        )
                        Button(onClick = {
                            responseString.value = responseString.value + viewModel.callGemini(prompt.value)?.text.toString() + "|"
                            promptString.value   = promptString.value + prompt.value + "|"
                            prompt.value = ""
                                         },
                            modifier = Modifier
                            .width(200.dp)
                            .height(80.dp)
                            .padding(bottom = 5.dp)) {
                            Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                        }
                    }
                }
            }
        )
    }
}