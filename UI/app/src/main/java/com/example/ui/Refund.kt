package com.example.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Refund(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(myPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.undo_arrow),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(myPadding))
        Text(
            text = "Google Play refund policy",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
    Text(
        text = "All prices include VAT.", modifier = Modifier
            .padding(horizontal = myPadding)
            .padding(bottom = myPadding)
    )
}