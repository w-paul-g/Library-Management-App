package com.me.librarymanagementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.me.librarymanagementsystem.data.AuthViewModel
import com.me.librarymanagementsystem.navigation.AppNavHost
import com.me.librarymanagementsystem.navigation.ROUTE_HOME
import com.me.librarymanagementsystem.navigation.ROUTE_WELCOME
import com.me.librarymanagementsystem.ui.theme.LibraryManagementSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryManagementSystemTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    val context = LocalContext.current
                    val account = AuthViewModel(
                        navController = NavHostController(context),
                        context = context
                    )
                    AppNavHost(
                        startDestination = if (account.isSignedIn()){
                            ROUTE_HOME
                        } else {
                            ROUTE_WELCOME
                        }
                    )
                }
            }
        }
    }
}
