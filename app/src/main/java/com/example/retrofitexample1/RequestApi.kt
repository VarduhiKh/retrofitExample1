package com.example.retrofitexample1

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RequestApi {

    @GET("public-api/products/2")
    fun getSingleUser(): Call<UserDetailModel.UserDetail>
}
