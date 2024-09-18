package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun More(modifier: Modifier = Modifier) {
    var clicked by remember { mutableStateOf(false) }

    ClickableRow(text = "More by Meta Platforms, Inc.", imageVector = Icons.Outlined.ArrowForward) {
        clicked = true
    }
    if (clicked) {
        println("More by Meta Platforms, Inc.")
    }

    Row(
        modifier = Modifier
            .padding(horizontal = myPadding)
            .horizontalScroll(rememberScrollState())
    ) {
        OtherAppInfo(appName = "Facebook Lite", rating = "4.0", imageId = R.drawable.facebook_lite)
        OtherAppInfo(
            appName = "Meta Business Suite",
            rating = "4.8",
            imageId = R.drawable.meta_business_suite
        )
        OtherAppInfo(
            appName = "Meta Ads Manager",
            rating = "4.7",
            imageId = R.drawable.meta_ads_manager
        )
        OtherAppInfo(
            appName = "Meta Spark Player",
            rating = "4.9",
            imageId = R.drawable.meta_spark_player
        )
        OtherAppInfo(
            appName = "Workplace From Meta",
            rating = "4.8",
            imageId = R.drawable.workplace_from_meta
        )
        OtherAppInfo(
            appName = "Workplace Chat From Meta",
            rating = "4.3",
            imageId = R.drawable.workplace_chat_from_meta
        )
    }
}

@Composable
fun OtherAppInfo(appName: String, rating: String, imageId: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.Start) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 10.dp,
            modifier = Modifier.size(100.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = appName,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(100.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = rating, fontSize = 10.sp)
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(10.dp)
            )
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}
