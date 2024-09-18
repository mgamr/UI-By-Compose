package com.example.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar() {
    var expanded by remember {
        mutableStateOf(false)
    }

    var checkState by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { println("Go Back") }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { println("Search") }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
            IconButton(onClick = { expanded = true }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text(text = "Share") },
                    onClick = {
                        expanded = false
                        println("Share")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Flag as inappropriate") },
                    onClick = {
                        expanded = false
                        println("Flag as inappropriate")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = null
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Enable auto update") },
                    onClick = {
                        checkState = !checkState
                        expanded = false
                        if (checkState)
                            println("Enable auto update")
                        else
                            println("Disable auto update")
                    },
                    trailingIcon = {
                        Checkbox(
                            checked = checkState,
                            onCheckedChange = {
                                checkState = it
                                expanded = false
                                if (checkState)
                                    println("Enable auto update")
                                else
                                    println("Disable auto update")
                            }
                        )
                    }
                )
            }
        }
    )
}