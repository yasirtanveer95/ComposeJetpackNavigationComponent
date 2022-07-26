package com.example.composenavigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column {
//                Row(
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(10.dp)
//                ) {
//                    Text(text = "Home", modifier = Modifier
//                        .background(Color.Cyan)
//                        .clickable {
//                            navController.navigate("home")
//                        })
//                    Text(text = "Favorite", modifier = Modifier
//                        .background(Color.Magenta)
//                        .clickable {
//                            navController.navigate("fav")
//                        })
//                    Text(text = "Setting", modifier = Modifier
//                        .background(Color.Gray)
//                        .clickable {
//                            navController.navigate("setting")
//                        })
//                }
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    listOf("home", "fav", "setting").forEach { routeItem ->
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                            label = { Text("Home") },
                            selected = currentDestination?.hierarchy?.any { it.route == routeItem } == true,
                            onClick = {
                                navController.navigate(routeItem) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }

                }
                NavHost(navController = navController, startDestination = "home") {
                    homeGraph(navController)
                    composable("fav") {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Favorite", modifier = Modifier.clickable {
                                navController.navigate("setting")
                            })
                        }
                    }
                    settingGraph(navController)
                }
            }
            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.route) {
                    "home" -> {
                        Toast.makeText(
                            this,
                            "1",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    "fav" -> {
                        Toast.makeText(
                            this,
                            "2",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    "setting" -> {
                        Toast.makeText(
                            this,
                            "3",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}