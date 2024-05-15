package com.me.librarymanagementsystem.models

class User {
    var  email : String=""
    var password :String =""
    var fullName:String=""
    var phoneNumber:String=""
    var userid:String=""

    constructor(email:String,password:String,fullName:String ,phoneNumber: String,userid:String){
        this.email=email
        this.password=password
        this.phoneNumber= phoneNumber
        this.fullName=fullName
        this.userid=userid
    }
    constructor()
}