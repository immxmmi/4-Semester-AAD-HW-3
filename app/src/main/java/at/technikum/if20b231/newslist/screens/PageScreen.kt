package at.technikum.if20b231.newslist.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import at.technikum.if20b231.newslist.NewsListViewModel
import at.technikum.if20b231.newslist.R
import at.technikum.if20b231.newslist.modle.Page


@Composable
fun PageScreen(navController: NavController, viewModel: NewsListViewModel) {
    val context = LocalContext.current
    var page = Page("test", "test", "test", "test", null, "test", "test")
    Column {
        TopAppBar(
            title = { Text(stringResource(R.string.pageTitle)) })

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
        ) {
            page.id?.let {
                Text(
                    text = "Unique identifier: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            page.title?.let {
                Text(
                    text = "Title: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            page.descriptor?.let {
                Text(
                    text = "Description: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            page.imageURL?.let {
                Text(
                    text = "Image URL: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            page.author?.let {
                Text(
                    text = "Author: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }


            page.author?.let {
                Text(
                    text = "Publication date: muss noch ausgebessert werden",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            page.articleURL?.let {
                Text(
                    text = "Full article link: $it",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth(),
                onClick = {
                             Toast.makeText(context,"Hallo Welt", Toast.LENGTH_SHORT).show()

                    //navController.navigate(Screen.ListPage.route)

                }) {
                Text(text = "back")
            }
        }

    }
}

@Composable
fun ShowSinglePage(navController: NavController, viewModel: NewsListViewModel){
    PageScreen(navController = rememberNavController(),viewModel)
}