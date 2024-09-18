package com.example.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppSupport(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var iconExpand =
        if (expanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown

    Column {
        ClickableRow(text = "App support", imageVector = iconExpand) {
            expanded = !expanded
        }
        if (expanded) {
            AppSupportRows(
                icon = painterResource(id = R.drawable.earth),
                text = "Website",
                subtext = null
            )
            AppSupportRows(
                icon = Icons.Outlined.Email,
                text = "Email",
                subtext = "android-support@fb.com"
            )
            AppSupportRows(
                icon = Icons.Outlined.LocationOn,
                text = "Address",
                subtext = "1 Hacker Way Menlo Park, CA 94025"
            )
            AppSupportRows(
                icon = painterResource(id = R.drawable.privacy_policy),
                text = "Privacy Policy",
                subtext = null
            )
        }
    }
}


@Composable
fun DataSafety(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var iconExpand =
        if (expanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown

    ClickableRow(text = "Data Safety", imageVector = iconExpand) {
        expanded = !expanded
    }
    if (expanded) {
        Text(
            modifier = Modifier.padding(horizontal = myPadding),
            text = "Safety starts with understanding how developers " +
                    "collect and share your data. Data privacy and security " +
                    "practices may vary based on your use, region and age. The " +
                    "developer provided this information and may update it over time."
        )

        Box(
            modifier = Modifier
                .padding(myPadding)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Column {
                AppSupportRows(
                    icon = Icons.Outlined.Share,
                    text = "This app may share these data types with third parties",
                    subtext = "Personal info and Device or other IDs"
                )
                AppSupportRows(
                    icon = painterResource(id = R.drawable.cloud_upload),
                    text = "This app may collect these data types",
                    subtext = "Location, Personal info and 12 others"
                )
                AppSupportRows(
                    icon = Icons.Outlined.Lock,
                    text = "Data is encrypted in transit",
                    subtext = null
                )
                AppSupportRows(
                    icon = Icons.Outlined.Delete,
                    text = "You can request that data be deleted",
                    subtext = null
                )
                TextButton(
                    onClick = { println("See details") }
                ) {
                    Text(text = "See details")
                }
            }
        }
    }
}

@Composable
fun ClickableRow(text: String, imageVector: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(myPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}

@Composable
fun AppSupportRows(icon: Any, text: String, subtext: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        when (icon) {
            is Painter -> {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = myPadding)
                        .size(23.dp),
                    painter = icon,
                    contentDescription = null
                )
            }

            is ImageVector -> {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = myPadding)
                        .size(23.dp),
                    imageVector = icon,
                    contentDescription = null
                )
            }
        }
        Column {
            Text(text = text, fontWeight = FontWeight.Medium)
            if (subtext != null)
                Text(text = subtext)
        }
    }
}
