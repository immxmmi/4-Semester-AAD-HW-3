package at.technikum.if20b231.newslist.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import at.technikum.if20b231.newslist.NewsListViewModel
import at.technikum.if20b231.newslist.R
import at.technikum.if20b231.newslist.modle.Page
import at.technikum.if20b231.newslist.ui.theme.NewsListTheme

@Composable
fun PageItem(page: Page,
             navController: NavController
){
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .border(0.02.dp, color = Color.Black)
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),

        ){

        Text(
            modifier = Modifier.clickable(enabled = true){
                                                         // Toast.makeText(context,"Hallo Welt", Toast.LENGTH_SHORT).show()
                navController.navigate(route = Screen.PageDetail.route)
            },
            text = "${page.title}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ShowListOfPages (navController: NavController,model: NewsListViewModel) {
//fun ShowListOfPages (navController: NavController,pages: List<Page>) {
    var page: List<Page>? = model.loadTest()
    if (page == null){
        page = listOf(
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","b","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","b","Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","b","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","b","c","d",null,"d","d"),
            Page("Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics","b","c","d",null,"d","d"),
        )
    }


    NewsListTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {

                TopAppBar(
                    title = { Text(stringResource(R.string.app_title)) })
                LazyColumn {
                    items(items = page) { page ->
                        PageItem(page = page,navController)
                    }
                }
            }
        }
    }
}


