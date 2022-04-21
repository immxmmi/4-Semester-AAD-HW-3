package at.technikum.if20b231.newslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import at.technikum.if20b231.newslist.handler.XMLParser
import at.technikum.if20b231.newslist.modle.Page
import at.technikum.if20b231.newslist.screens.ShowListOfPages
import java.io.IOException

class MainActivity : ComponentActivity() {

    // NavHost
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         //  NewsListTheme {
         //      navController = rememberNavController()
         //      SetupNavGraph(navController = navController)
         //  }


        var pages: List<Page>? = null


        try {
            val parsNew = XMLParser()
            val istream = assets.open("rss.xml")
            //    var stre = getResponseFromHttpUrl("https://www.engadget.com/rss.xml")
            pages = parsNew.parse(istream)


        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (pages != null) {
            ShowListOfPages(PageList = pages)
        }



        }

    }
}

