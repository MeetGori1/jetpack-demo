package com.example.qutoteapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.qutoteapp.models.Quotes

@Composable
fun QuoteList(data: Array<Quotes>, onClick: (quote: Quotes) -> Unit) {

    LazyColumn(content = {
        item {
            Text(
                text = "Quotes App",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp, 24.dp),
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = FontFamily.Cursive
            )
        }
        items(data) {
            QuoteListItem(quote = it,onClick)
        }

    }
    )

}