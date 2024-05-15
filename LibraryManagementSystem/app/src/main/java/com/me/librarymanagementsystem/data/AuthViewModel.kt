package com.me.librarymanagementsystem.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.me.librarymanagementsystem.navigation.ROUTE_HOME
import com.me.librarymanagementsystem.navigation.ROUTE_SIGNIN
import com.me.librarymanagementsystem.navigation.ROUTE_SIGNUP

class AuthViewModel(var navController: NavController, var context: Context) {
    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait a moment.....")
    }


    fun signUp(email: String, password: String) {
//         Validate input fields
        if (email.isNotBlank() && password.isNotBlank()) {
            // Call Firebase to create a user with email and password
            progress.show()
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context,"Successfully Registered!",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_HOME)}
//
                // Sign up success, navigate to next screen or do something else
                else {
                    // Sign up failed, display an error message
                    Toast.makeText(context, "Sign up failed. ${it.exception!!.message}", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_SIGNUP)
                }
            }


        }

        else{
            Toast.makeText(context, "Please fill in all the fields!", Toast.LENGTH_LONG).show()
        }

    }



    fun signIn(email: String, password: String, ) {
        progress.show()
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIFFERENT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_SIGNIN)
            }
        }
    }
    fun signOut(){
        mAuth.signOut()
        navController.navigate(ROUTE_SIGNIN)
    }

    fun isSignedIn():Boolean{
        return mAuth.currentUser !=null
    }

    fun resetPassword(email: String){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener {
            if (it.isSuccessful) {
                // Password reset email sent successfully
                Toast.makeText(context,"Password reset email sent successfully",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_SIGNIN)
            } else {
                // Password reset email could not be sent
                Toast.makeText(context,"Password reset email could not be sent",Toast.LENGTH_LONG).show()
            }
        }
//
    }
}