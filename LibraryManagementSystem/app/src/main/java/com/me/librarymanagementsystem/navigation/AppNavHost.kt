package com.me.librarymanagementsystem.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.me.librarymanagementsystem.ui.account.ForgotPassword
import com.me.librarymanagementsystem.ui.account.SignIn
import com.me.librarymanagementsystem.ui.account.SignOutAlert
import com.me.librarymanagementsystem.ui.account.SignUp
import com.me.librarymanagementsystem.ui.books.AddNewBook
import com.me.librarymanagementsystem.ui.books.BorrowBook
import com.me.librarymanagementsystem.ui.books.ManageBooks
import com.me.librarymanagementsystem.ui.books.ManageBorrowedBooks
import com.me.librarymanagementsystem.ui.books.ReturnBorrowedBook
import com.me.librarymanagementsystem.ui.books.UpdateBook
import com.me.librarymanagementsystem.ui.home.HomeScreen
import com.me.librarymanagementsystem.ui.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_WELCOME

){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable(ROUTE_WELCOME) {
            WelcomeScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_SIGNOUT){
            SignOutAlert(navController)
        }
        composable(ROUTE_SIGNIN){
            SignIn(navController)
        }
        composable(ROUTE_SIGNUP){
            SignUp(navController)
        }
        composable(ROUTE_FORGOT_PASSWORD){
            ForgotPassword(navController)
        }
        composable(ROUTE_ADD_BOOK){
            AddNewBook(navController)
        }
        composable(ROUTE_VIEW_BOOK){
            ManageBooks(navController)
        }
        composable(ROUTE_BORROW_BOOK){
            BorrowBook(navController)
        }
        composable(ROUTE_BORROWED_BOOKS){
            ManageBorrowedBooks(navController,)
        }
        composable(ROUTE_RETURN_BOOK){
            ReturnBorrowedBook(navController)
        }
        composable(ROUTE_UPDATE_BOOK + "/{id}"){
                passedData ->
            UpdateBook(
                navController,passedData.arguments?.getString("id")!!
            )
        }
    }
}
