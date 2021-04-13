package com.example.retrofitexample1

class UserDetailModel {

    var data: UserDetail? = null

    data class UserDetail (
        var id: Int,
        var name: String,
        var description: String,
        var price: String,
        var discount_amount: String
    )
}