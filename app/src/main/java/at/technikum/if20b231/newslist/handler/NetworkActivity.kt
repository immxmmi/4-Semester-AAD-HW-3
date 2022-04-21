package at.technikum.if20b231.newslist.handler

import android.os.AsyncTask
import at.technikum.if20b231.newslist.modle.Page
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity {

    //VieModel

    companion object {
        const val SO_URL = "https://www.engadget.com/rss.xml"
    }


    var pages : List<Page>? = null




    fun loadPage() {
            DownloadXmlTask().execute(SO_URL)
    }



    @Throws(XmlPullParserException::class, IOException::class)
    private fun loadXmlFromNetwork(urlString: String): List<Page> {
        val currentPages: List<Page> = downloadUrl(urlString)?.use { stream ->
            // Instantiate the parser
                XMLParser().parse(stream)
        } ?: emptyList()

        pages = currentPages

        return currentPages
    }

    // Given a string representation of a URL, sets up a connection and gets
// an input stream.
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

    // Implementation of AsyncTask used to download XML feed from stackoverflow.com.
    private inner class DownloadXmlTask : AsyncTask<String, Void, List<Page>>() {
        override fun doInBackground(vararg urls: String): List<Page>? {
            return try {
              loadXmlFromNetwork(urls[0])
            } catch (e: IOException) {
                 null
            } catch (e: XmlPullParserException) {
                null
            }
        }
        override fun onPostExecute(result: List<Page>?) {
                    pages = result
        }

    }
}