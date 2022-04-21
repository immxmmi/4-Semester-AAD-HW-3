package at.technikum.if20b231.newslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import at.technikum.if20b231.newslist.handler.NetworkActivity
import at.technikum.if20b231.newslist.modle.Page

class MainActivity : ComponentActivity() {

    // NavHost
    private lateinit var navController: NavHostController

    //VieModel
    private val model: NewsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {




            var network = NetworkActivity()
            network.loadPage()
            var pages: List<Page>? = network.pages






         //  NewsListTheme {
         //      navController = rememberNavController()
         //      SetupNavGraph(navController = navController)
         //  }


    //   var pages: List<Page>? = null

    //       pages = GetXMLFromFile().loadXML()










        }

    }
}

