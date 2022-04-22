package com.adl.ujianadlretrofit.service

import com.adl.ujianadlretrofit.model.GetLoginUserResponse
import com.adl.ujianadlretrofit.model.LoginUserPostData
import retrofit2.Call
import retrofit2.http.*

interface ILogin {

    @Headers("X-Api-Key:09FEAB3A4B5822697BA232274FBC3B04")
    @GET("api/login/all")
    fun getAllLogin(@Query("filter")query:String): Call<GetLoginUserResponse>

    @FormUrlEncoded
    @Headers("X-Api-Key:09FEAB3A4B5822697BA232274FBC3B04")
    @POST("api/login/add")
    fun addLogin(@Field("username") username:String,
                    @Field("password") password:String): Call<LoginUserPostData>

}