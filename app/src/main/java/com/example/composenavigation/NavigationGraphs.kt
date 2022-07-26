package com.example.composenavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(startDestination = "tab1", route = "home") {

        composable("tab1") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Home Tab 1", modifier = Modifier.clickable {
                    navController.navigate("tab2")
                })
            }
        }

        composable("tab2") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Home Tab 2", modifier = Modifier.clickable {
                    navController.navigate("tab3")
                })
            }
        }

        composable("tab3") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Home End")
            }
        }
    }
}

fun NavGraphBuilder.settingGraph(navController: NavHostController) {
    navigation(
        startDestination = "settingTab1",
        route = "setting",
        deepLinks = listOf(NavDeepLink(uri = "https://www.google.com/")/* navDeepLink { uriPattern = "https://www.google.com/" }*/)
    ) {

        composable("settingTab1") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Setting Tab 1", modifier = Modifier.clickable {
                    navController.navigate("settingTab2")
                })
            }
        }

        composable("settingTab2") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Setting Tab 2", modifier = Modifier.clickable {
                    navController.navigate("settingTab3")
                })
            }
        }

        composable("settingTab3") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Setting End")
            }
        }
    }
}