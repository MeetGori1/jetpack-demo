package com.example.qutoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.qutoteapp.models.Quotes

@Composable
fun QuoteListScreen(data: Array<Quotes>, onClick: (quote:Quotes) -> Unit) {
    Column {
        QuoteList(data = data,onClick)
}}