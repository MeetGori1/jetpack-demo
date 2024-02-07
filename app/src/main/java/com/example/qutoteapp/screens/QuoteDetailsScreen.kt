package com.example.qutoteapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.qutoteapp.models.Quotes
import com.example.qutoteapp.utils.DataManager


@Composable
fun QuoteDetails(quotes: Quotes) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(Color(0xFFffffff), Color(0xFFE3E3E3))
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .padding(34.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.Black),
                    alignment = Alignment.TopStart,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(50.dp)
                        .scale(1.5f)
                        .rotate(180f)
                )
                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(1.0f)
                )
                Column {
                    Text(
                        text = quotes.quote,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = quotes.author,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Thin
                    )

                }
            }
        }
    }
}