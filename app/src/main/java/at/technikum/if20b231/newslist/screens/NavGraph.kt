package at.technikum.if20b231.newslist.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import at.technikum.if20b231.newslist.NewsListViewModel


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: NewsListViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.ListPage.route
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
            ShowListOfPages(navController = navController,viewModel)
        }

        // Single Page
        composable(
            route = Screen.PageDetail.route
        ){
            ShowSinglePage(navController = navController,viewModel)
        }
    }
}