package com.me.librarymanagementsystem.ui.books

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.me.librarymanagementsystem.R
import com.me.librarymanagementsystem.data.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReturnBorrowedBook(
    navController: NavHostController
){
    var context = LocalContext.current
    var bookState = BookViewModel(navController, context)
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text("Return Borrowed Books")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
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
        ){
            Image(
                painter = painterResource(id = R.drawable.pic4),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .blur(300.dp)
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ReturnBooksForm { bookTitle, author, isbn, returnDate ->
                        // Handle the book return action
                        // For example, you can print the details to the log
                        println("Returning book: $bookTitle by $author (ISBN: $isbn), Return Date: $returnDate")
                    }
                }
            }
        }
    }
}


@SuppressLint("RememberReturnType")
@Composable
fun ReturnBooksForm(onReturnBook: (String, String, String,String) -> Unit) {
    val bookTitleState = remember {
        mutableStateOf(
            TextFieldValue()
        )
    }
    val authorState = remember {
        mutableStateOf(
            TextFieldValue()
        )
    }
    val isbnState = remember {
        mutableStateOf(
            TextFieldValue()
        )
    }
    val returnDateState = remember {
        mutableStateOf(
            TextFieldValue()
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = bookTitleState.value,
                onValueChange = { bookTitleState.value = it },
                label = { Text("Book Title") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = authorState.value,
                onValueChange = { authorState.value = it },
                label = { Text("Author") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = isbnState.value,
                onValueChange = { authorState.value = it },
                label = { Text("ISBN") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = returnDateState.value,
                onValueChange = { returnDateState.value = it },
                label = { Text("Return Date") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    onReturnBook(
                        bookTitleState.value.text,
                        authorState.value.text,
                        isbnState.value.text,
                        returnDateState.value.text
                    )
                }),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Button(
                onClick = {
                    onReturnBook(
                        bookTitleState.value.text,
                        authorState.value.text,
                        isbnState.value.text,
                        returnDateState.value.text
                    )
                }
            ) {
                Text(text = "Return Book")
            }
        }
    }
}