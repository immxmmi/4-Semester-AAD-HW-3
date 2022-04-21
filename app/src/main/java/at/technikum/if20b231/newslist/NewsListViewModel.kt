package at.technikum.if20b231.newslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsListViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


}