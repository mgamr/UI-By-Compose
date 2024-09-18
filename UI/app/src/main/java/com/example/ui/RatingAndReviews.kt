package com.example.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingsAndReviews(modifier: Modifier = Modifier) {
    var clicked by remember { mutableStateOf(false) }

    ClickableRow(text = "Ratings and reviews", imageVector = Icons.Outlined.ArrowForward) {
        clicked = true
    }
    if (clicked) {
        println("Ratings and reviews")
    }

    TextWithIcon(
        str = "Ratings and reviews are verified and are from " +
                "people who use the same type of device that you use ",
        icon = Icons.Outlined.Info,
        size = 16
    )

    RatingSumUp("4.3", "13,326,423", 0.8f, 0.2f, 0.1f, 0.1f, 0.3f)
    Reviews()
    TextButton(
        onClick = { println("See all reviews") },
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text = "See all reviews")
    }
}

@Composable
fun RatingSumUp(
    ratingNumber: String,
    reviewNumber: String,
    fraction5Star: Float,
    fraction4Star: Float,
    fraction3Star: Float,
    fraction2Star: Float,
    fraction1Star: Float,
    modifier: Modifier = Modifier
) {
    Row(modifier = Modifier.padding(myPadding)) {
        Column {
            Row {
                Text(
                    text = ratingNumber,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(4) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = myBlue
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.star_half_empty),
                    contentDescription = null,
                    modifier = Modifier.size(11.4.dp),
                    tint = myBlue
                )
            }

            Row {
                Text(text = reviewNumber, fontSize = 11.sp)
            }
        }

        Column {
            RatingBar(enum = "5", fraction = fraction5Star)
            RatingBar(enum = "4", fraction = fraction4Star)
            RatingBar(enum = "3", fraction = fraction3Star)
            RatingBar(enum = "2", fraction = fraction2Star)
            RatingBar(enum = "1", fraction = fraction1Star)
        }
    }
}

@Composable
fun RatingBar(enum: String, fraction: Float, modifier: Modifier = Modifier) {
    val height = 9
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(text = enum, modifier = Modifier.padding(horizontal = 20.dp))
        Box(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.LightGray)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction)
                    .height(height.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(myBlue)
            )
        }
    }
}


@Composable
fun Reviews(modifier: Modifier = Modifier) {
    Review(
        userName = "Sudhanshu Singh",
        imageId = R.drawable.s,
        stars = 5,
        date = "4/5/24",
        comment = "Messenger is really good and so far I'm enjoying it. Only issue " +
                "is that when I'm downloading a file, it downloaded upto the and then " +
                "suddenly it says file is not downloading try again.",
        numHelped = "576"
    )

    Review(
        userName = "John Silver",
        imageId = R.drawable.j,
        stars = 5,
        date = "3/16/24",
        comment = "Amazing app with endless possibilities. It's super super powerful, " +
                "but there is definetely scope for improvement. One little suggestion " +
                "from my side is that you could probably add ...",
        numHelped = "3,313"
    )

    Review(
        userName = "Celleste Connolly",
        imageId = R.drawable.c,
        stars = 1,
        date = "4/6/24",
        comment = "For 2 weeks I've had constant issues with the app not updating the " +
                "message preview screen, not confirming my messages have sent with the " +
                "tick in the circle and saying either..",
        numHelped = "771"
    )

    Review(
        userName = "Jecelle Mayne",
        imageId = R.drawable.selfie,
        stars = 1,
        date = "4/5/24",
        comment = "Too many problems encountered 1. When i send pics or videos it always " +
                "ended up failed -- it took me 2-3 tries to successfully send it even my " +
                "internet is in good speed 2. When I switch account...",
        numHelped = "2,653"
    )
}


@Composable
fun Review(
    userName: String,
    imageId: Int,
    stars: Int,
    date: String,
    comment: String,
    numHelped: String,
    modifier: Modifier = Modifier
) {
    ShowUser(userName, imageId)
    StarsAndDate(stars, date)
    Comment(comment)
    HelpfulComment(numHelped)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowUser(userName: String, imageId: Int, modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {},
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(horizontal = myPadding)
            ) {

                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(myPadding))
                Text(text = userName, modifier = Modifier.weight(1f))
            }
        },
        actions = {
            IconButton(
                onClick = { expanded = true }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Flag as inappropriate") },
                    onClick = {
                        expanded = !expanded
                        println("Flag as inappropriate")
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Flag as spam") },
                    onClick = {
                        expanded = !expanded
                        println("Flag as spam")
                    }
                )
            }
        }
    )

}

@Composable
fun StarsAndDate(stars: Int, date: String, modifier: Modifier = Modifier) {
    val maxStars = 5

    Row(
        modifier = Modifier.padding(horizontal = myPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(stars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = myBlue
            )
        }

        repeat(maxStars - stars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = Color.LightGray
            )
        }
        Text(text = date, fontSize = 11.sp, modifier = Modifier.padding(horizontal = 8.dp))
    }
}

@Composable
fun Comment(comment: String, modifier: Modifier = Modifier) {
    var showMore by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(20.dp)) {
        Column(modifier = Modifier
            .animateContentSize(animationSpec = tween(100))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { showMore = !showMore }) {

            if (showMore) {
                Text(
                    text = comment,
                    fontSize = 15.sp,
                    lineHeight = 17.sp
                )
            } else {
                Text(
                    text = comment,
                    fontSize = 15.sp,
                    lineHeight = 17.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun HelpfulComment(numHelped: String, modifier: Modifier = Modifier) {
    Text(
        text = "$numHelped people found this helpful",
        fontSize = 11.sp,
        modifier = Modifier.padding(horizontal = myPadding)
    )

    Row(
        modifier = Modifier.padding(horizontal = myPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Was this review helpful?", fontSize = 11.sp, modifier = Modifier.weight(1f))
        OutlinedButton(
            onClick = { println("Yes") },
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
            modifier = Modifier
                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            shape = RoundedCornerShape(20)
        ) {
            Text(
                text = "Yes",
                fontSize = 11.sp
            )
        }
        OutlinedButton(
            onClick = { println("No") },
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
            modifier = Modifier
                .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            shape = RoundedCornerShape(20)
        ) {
            Text(
                text = "No",
                fontSize = 11.sp
            )
        }
    }
}


@Composable
fun TextWithIcon(str: String, icon: ImageVector, size: Int) {
    val myId = "inlineContent"
    val text = buildAnnotatedString {
        append(str)
        appendInlineContent(myId, "[icon]")
    }

    val inlineContent = mapOf(
        Pair(
            myId,
            InlineTextContent(
                Placeholder(
                    width = size.sp,
                    height = size.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            ) {
                Icon(imageVector = icon, contentDescription = null)
            }
        )
    )

    Text(
        text = text,
        modifier = Modifier.padding(size.dp),
        fontSize = size.sp,
        inlineContent = inlineContent
    )
}

