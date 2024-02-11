package com.gemini.geminews.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gemini.geminews.presentation.chatscreen.ChatScreenViewModel
import com.gemini.geminews.presentation.homescreen.HomeScreen
import com.gemini.geminews.presentation.homescreen.HomeScreenViewModel
import com.gemini.geminews.presentation.navigation.NavGraph
import com.gemini.geminews.presentation.test.TestScreen
import com.gemini.geminews.presentation.test.TestViewModel
import com.gemini.geminews.ui.theme.GemiNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GemiNewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeScreenViewModel: HomeScreenViewModel by viewModels()
                    val chatScreenViewModel: ChatScreenViewModel by viewModels()
                    NavGraph(
                        homeScreenViewModel,
                        chatScreenViewModel
                    )
                }
            }
        }
    }
}