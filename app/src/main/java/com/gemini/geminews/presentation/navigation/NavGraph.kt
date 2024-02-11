package com.gemini.geminews.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gemini.geminews.presentation.chatscreen.ChatScreen
import com.gemini.geminews.presentation.chatscreen.ChatScreenViewModel
import com.gemini.geminews.presentation.homescreen.HomeScreen
import com.gemini.geminews.presentation.homescreen.HomeScreenViewModel

@Composable
fun NavGraph(
    homeScreenViewModel: HomeScreenViewModel,
    chatScreenViewModel: ChatScreenViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavEnum.ChatScreen.name){
        composable(NavEnum.HomeScreen.name){
            HomeScreen(
                viewModel = homeScreenViewModel
            )
        }

        composable(NavEnum.ChatScreen.name){
            ChatScreen(viewModel = chatScreenViewModel)
        }
    }
}
