package at.technikum.if20b231.newslist.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        // Start
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }

        // List of Pages
        composable(
            route = Screen.ListPage.route
        ){
            PageScreen(navController = navController)
        }

        // Single Page
        composable(
            route = Screen.PageDetail.route
        ){
            PageScreen(navController = navController)
        }
    }
}