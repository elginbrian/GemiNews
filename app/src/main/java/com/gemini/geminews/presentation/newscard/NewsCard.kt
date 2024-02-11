package com.gemini.geminews.presentation.newscard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NewsCard(
    title: String = "This is Title",
    author: String = "This is Author",
    description: String = "This is Description",
    link: String = "This is Link"
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 15.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            /* TITLE */       Text(text = title, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            /* PUBLISHER */   Text(text = author)
            Spacer(modifier = Modifier.padding(8.dp))
            /* DESCRIPTION */ Text(text = description, textAlign = TextAlign.Justify)
            Spacer(modifier = Modifier.padding(5.dp))
            /* DESCRIPTION */ Text(text = link, textAlign = TextAlign.Right, color = Color.Yellow)
        }
    }
}