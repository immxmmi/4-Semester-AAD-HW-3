package at.technikum.if20b231.newslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import at.technikum.if20b231.newslist.screens.SetupNavGraph
import at.technikum.if20b231.newslist.ui.theme.NewsListTheme

class MainActivity : ComponentActivity() {


    // NavHost
    private lateinit var navController: NavHostController

    //VieModel
     val viewModel by viewModels<NewsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       //viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)

        
        setContent {

           // viewModel.getPages()

             NewsListTheme {
                 navController = rememberNavController()
                SetupNavGraph(navController = navController,viewModel)
             }
       //   ShowListOfPages(navController,pages)
        }



    }

}







//  NewsListTheme {
//      navController = rememberNavController()
//      SetupNavGraph(navController = navController)
//  }


//   var pages: List<Page>? = null

//       pages = GetXMLFromFile().loadXML()


