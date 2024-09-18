package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BetaTester(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(horizontal = myPadding)) {
        Text(
            text = "Switch accounts to become a beta tester",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = myPadding)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "This app is associated with a different account. " +
                        "To get beta updates for this app, first switch to " +
                        "that account in Play Store and join the beta.",
                modifier = modifier.weight(0.7f)
            )

            Image(
                painter = painterResource(id = R.drawable.beta_tester),
                contentDescription = null,
                modifier = modifier
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
                    .weight(0.2f),
                contentScale = ContentScale.Fit
            )
        }
        TextButton(
            onClick = { println("Learn more") }
        ) {
            Text(text = "Learn more")
        }
    }
}