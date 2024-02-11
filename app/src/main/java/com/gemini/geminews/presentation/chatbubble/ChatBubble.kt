package com.gemini.geminews.presentation.chatbubble

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ChatRequest(request: String = "Lorem Ipsum"){
    Row {
        Spacer(modifier = Modifier.fillMaxWidth(0.2f))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp, bottomEnd = 15.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
                Text(text = request)
            }
        }
    }
}

@Preview
@Composable
fun ChatResponse(response: String = "Lorem Ipsum"){
    Card(
        modifier = Modifier.fillMaxWidth(0.8f),
        shape = RoundedCornerShape(topEnd = 15.dp, bottomStart = 15.dp, bottomEnd = 15.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
            Text(text = response)
        }
    }
}