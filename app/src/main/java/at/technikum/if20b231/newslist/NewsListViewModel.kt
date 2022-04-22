package at.technikum.if20b231.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.technikum.if20b231.newslist.handler.XMLParser
import at.technikum.if20b231.newslist.modle.Page
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class NewsListViewModel : ViewModel() {

    private val pages : MutableLiveData<List<Page>> by lazy {
        MutableLiveData<List<Page>>().also {
            loadPages(it)
        }
    }
    val load:LiveData<List<Page>>
        get() = pages



    private fun loadPages(liveData: MutableLiveData<List<Page>>) {
        viewModelScope.launch {
            liveData.value =  loadWebResult()
        }
    }

    public fun orderListByDate (pages:List<Page>): List<Page> {
        return pages.sortedBy { it.pubDate }
    }

    public fun orderListByAuthor (pages:List<Page>): List<Page> {
        return pages.sortedBy { it.author }
    }

    public fun orderListByTitle(pages:List<Page>): List<Page> {
        return pages.sortedBy { it.title }
    }

    fun getPages(): LiveData<List<Page>> {
        return pages
    }


    //LOAD RESULT
    private suspend fun loadWebResult(): List<Page> {

        val url = "https://www.engadget.com/rss.xml"

        return withContext(Dispatchers.IO) { loadXmlFromNetwork(url) }
    }

}




@Throws(XmlPullParserException::class, IOException::class)
private fun loadXmlFromNetwork(urlString: String): List<Page> {
    val currentPages: List<Page> = downloadUrl(urlString)?.use { stream ->
        XMLParser().parse(stream)
    } ?: emptyList()

    return currentPages
}
@Throws(IOException::class)
private fun downloadUrl(urlString: String): InputStream? {
    val url = URL(urlString)
    return (url.openConnection() as? HttpURLConnection)?.run {
        readTimeout = 10000
        connectTimeout = 15000
        requestMethod = "GET"
        doInput = true
        // Starts the query
        connect()
        inputStream
    }
}


