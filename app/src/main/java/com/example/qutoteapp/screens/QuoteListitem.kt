package com.example.qutoteapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qutoteapp.models.Quotes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteListItem(quote: Quotes, onclick: (quote:Quotes) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(8.dp),
        onClick = { onclick(quote) }

    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.labelLarge
                )
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth(1.0f)
                        .height(1.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Thin
                )

            }
        }
    }
}

/*@Preview
@Composable
fun QuoteListItem() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { }
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "water Desai",
                    style = MaterialTheme.typography.labelLarge
                )
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth(1.0f)
                        .height(1.dp)
                )
                Text(
                    text = "i am water",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Thin
                )

            }
        }
    }
}*/


