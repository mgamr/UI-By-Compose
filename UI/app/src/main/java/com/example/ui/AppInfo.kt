package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App(modifier: Modifier = Modifier) {
    val appName = "Messenger"
    val companyName = "Meta Platforms, Inc."
    val purchase = "In-app purchases"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(myPadding)
    ) {
        Spacer(modifier = Modifier.width(myPadding))
        Surface(
            shape = RoundedCornerShape(myPadding),
            shadowElevation = 10.dp,
            modifier = Modifier.size(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.messenger),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(myPadding))
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = appName,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = companyName,
                fontSize = 15.sp,
                color = myBlue
            )
            Text(
                text = purchase,
                fontSize = 13.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun Buttons(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(
            onClick = { println("Uninstall") },
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = myBlue
            )
        ) { Text("Uninstall") }
        Button(
            onClick = { println("Open") },
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = myBlue
            )
        ) { Text("Open") }
    }
}

@Composable
fun AppImages(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(myPadding)
            .horizontalScroll(rememberScrollState())
    ) {
        RoundedScreens(R.drawable.image_1)
        Spacer(modifier = Modifier.width(8.dp))
        RoundedScreens(R.drawable.image_2)
        Spacer(modifier = Modifier.width(8.dp))
        RoundedScreens(R.drawable.image_3)
        Spacer(modifier = Modifier.width(8.dp))
        RoundedScreens(R.drawable.image_4)
        Spacer(modifier = Modifier.width(8.dp))
        RoundedScreens(R.drawable.image_5)
        Spacer(modifier = Modifier.width(8.dp))
        RoundedScreens(R.drawable.image_6)
    }
}


@Composable
private fun RoundedScreens(imageResId: Int) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 10.dp,
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
private fun TextBox(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun About(modifier: Modifier = Modifier) {
    ClickableRow(text = "About this app", imageVector = Icons.Outlined.ArrowForward) {
        println("About this app")
    }
    Text(
        text = "Free group video chat, video calls, voice calls and text messaging.",
        modifier = Modifier.padding(horizontal = myPadding)
    )
    Row(modifier = Modifier.padding(myPadding)) {
        TextBox(text = "#3 top free in comunication")
        Spacer(modifier = Modifier.width(10.dp))
        TextBox(text = "Messaging")
    }
}

@Composable
fun AppMetrics(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(myPadding)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "4.2", fontSize = 15.sp, fontWeight = FontWeight.Medium)
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "84M reviews ", fontSize = 13.sp)
                Icon(
                    imageVector = Icons.Outlined.Info, contentDescription = null,
                    modifier = Modifier.size(13.dp)
                )
            }
        }

        Divider(
            color = Color.Gray, modifier = Modifier
                .fillMaxHeight(0.6f)
                .width(1.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.rated_12_plus),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Rated for 12+ ", fontSize = 13.sp)
                Icon(
                    imageVector = Icons.Outlined.Info, contentDescription = null,
                    modifier = Modifier.size(13.dp)
                )
            }
        }

        Divider(
            color = Color.Gray, modifier = Modifier
                .fillMaxHeight(0.6f)
                .width(1.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "5B+", fontSize = 15.sp, fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Downloads", fontSize = 13.sp)
            }
        }
    }
}