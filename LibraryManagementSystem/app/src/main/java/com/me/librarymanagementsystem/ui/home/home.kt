package com.me.librarymanagementsystem.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.me.librarymanagementsystem.R
import com.me.librarymanagementsystem.navigation.ROUTE_ADD_BOOK
import com.me.librarymanagementsystem.navigation.ROUTE_BORROWED_BOOKS
import com.me.librarymanagementsystem.navigation.ROUTE_BORROW_BOOK
import com.me.librarymanagementsystem.navigation.ROUTE_RETURN_BOOK
import com.me.librarymanagementsystem.navigation.ROUTE_SIGNOUT
import com.me.librarymanagementsystem.navigation.ROUTE_VIEW_BOOK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
){
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = "LIBRARY")
                },
                navigationIcon = {
                    TextButton(onClick = {
                        navController.navigate(ROUTE_VIEW_BOOK)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.MenuBook,
                            contentDescription = "Add"
                        )
                        Text(text = "OUR BOOKS")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        navController.navigate(ROUTE_ADD_BOOK)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add"
                        )
                        Text(text = "NEW BOOK")
                    }
                    var moreMenu by remember {
                        mutableStateOf(false)
                    }
                    TextButton(
                        onClick = {
                            moreMenu =! moreMenu
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Menu"
                        )
                        Text(text = "MENU")
                    }
                    DropdownMenu(
                        expanded = moreMenu,
                        onDismissRequest = { moreMenu = false },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(10.dp)
                    ) {
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Logout,
                                    contentDescription
                                    = "Logout"
                                )
                            },
                            text = {
                                Text(text = "SIGN OUT")
                            },
                            onClick = {
                                navController.navigate(ROUTE_SIGNOUT)
                            }
                        )
                    }
                }
            )
        }
    ) {
            innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .blur(4.dp)
        )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Card(
                            onClick = { navController.navigate(ROUTE_BORROW_BOOK) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(36.dp)
                        ) {

                            Text(
                                text = "BORROW A BOOK",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(36.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Card(
                            onClick = { navController.navigate(ROUTE_RETURN_BOOK) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(36.dp)
                        ) {

                            Text(
                                text = "RETURN A BOOK",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(36.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Card(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(36.dp)

                        ) {

                            Text(
                                text = "MANAGE BORROWED BOOKS",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(36.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview(){
    HomeScreen(navController = rememberNavController())
}