package com.example.qutoteapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.qutoteapp.screens.QuoteDetails
import com.example.qutoteapp.screens.QuoteListScreen
import com.example.qutoteapp.utils.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadQuotesFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        if (DataManager.isDataLoaded.value) {
            if (DataManager.currentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)
                }
            } else {
                DataManager.currentQuote?.let { QuoteDetails(quotes = it) }
            }

        } else {

            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
                Text(text = "Loading........", style = MaterialTheme.typography.bodyMedium)
            }
        }

    }
}

enum class Pages {
    LISTING, DETAILS
}



