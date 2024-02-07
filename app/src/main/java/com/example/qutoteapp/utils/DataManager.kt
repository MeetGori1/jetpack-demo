package com.example.qutoteapp.utils

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.qutoteapp.models.Quotes
import com.example.qutoteapp.ui.activity.Pages
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quotes>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quotes? = null

    fun loadQuotesFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quotes: Quotes?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quotes
            currentPage.value = Pages.DETAILS
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}