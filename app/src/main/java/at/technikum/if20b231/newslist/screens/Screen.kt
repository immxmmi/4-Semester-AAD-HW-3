package at.technikum.if20b231.newslist.screens

sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object ListPage: Screen("list_of_pages_screen")
    object PageDetail: Screen("page_screen")
}