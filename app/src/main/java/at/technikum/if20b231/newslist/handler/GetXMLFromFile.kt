package at.technikum.if20b231.newslist.handler

import android.app.Activity
import at.technikum.if20b231.newslist.modle.Page
import java.io.IOException

class GetXMLFromFile : Activity(){
    fun loadXML() : List<Page>? {
        try {
            val parsNew = XMLParser()
            val istream = assets.open("rss.xml")
            //    var stre = getResponseFromHttpUrl("https://www.engadget.com/rss.xml")
            return parsNew.parse(istream)


        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }
}