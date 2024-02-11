package com.gemini.geminews.presentation.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gemini.geminews.presentation.newscard.NewsCard

//@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
){
    val newsList = viewModel.getIDNews()

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
                LazyColumn(modifier = Modifier.fillMaxSize().padding(start = 15.dp, end = 15.dp)){
                    item {
                        Spacer(modifier = Modifier.padding(45.dp))
                    }
                    if (newsList != null) {
                        items(newsList.totalResults + 1) {article ->
                            NewsCard(
                                title       = newsList.articles[article].title,
                                author      = newsList.articles[article].author.toString(),
                                description = newsList.articles[article].content.toString(),
                                link        = newsList.articles[article].url
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.padding(50.dp))
                    }
                }
            },
            bottomBar = {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                    shape = RectangleShape,
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
                ) {

                }
            }
        )
    }
}