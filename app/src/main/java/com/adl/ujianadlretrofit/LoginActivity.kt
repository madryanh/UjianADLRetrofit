package com.adl.ujianadlretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.ujianadlretrofit.model.GetLoginUserResponse
import com.adl.ujianadlretrofit.model.LoginUserPostData
import com.adl.ujianadlretrofit.service.LoginConfig
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupUI()

        LoginConfig().getLogin().getAllLogin().enqueue(object :Callback<GetLoginUserResponse>{
            override fun onResponse(
                call: Call<GetLoginUserResponse>,
                response: Response<GetLoginUserResponse>
            ) {
                Log.d("Response",response.body().toString())
            }

            override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                Log.e("error request",t.localizedMessage.toString())
            }

        })

    }

    private fun setupUI(){
        btnLogin.setOnClickListener({
            LoginConfig().getLogin().getAllLogin().enqueue(object :Callback<GetLoginUserResponse>{
                override fun onResponse(
                    call: Call<GetLoginUserResponse>,
                    response: Response<GetLoginUserResponse>
                ) {
                    Toast.makeText(this@LoginActivity,(response.body() as GetLoginUserResponse).message,Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                    Log.e("error get data",t.localizedMessage.toString())
                }

            })
        })
    }


//    private fun setupUI(){
//        btnLogin.setOnClickListener({
//            LoginConfig().getLogin().addLogin(txtUsername.text.toString(),txtPassword.text.toString()
//            ).enqueue(object :Callback<LoginUserPostData>{
//                override fun onResponse(
//                    call: Call<LoginUserPostData>,
//                    response: Response<LoginUserPostData>
//                ) {
//                    Toast.makeText(this@LoginActivity,(response.body() as LoginUserPostData).message,Toast.LENGTH_LONG).show()
//                }
//
//                override fun onFailure(call: Call<LoginUserPostData>, t: Throwable) {
//                    Log.e("error post data",t.localizedMessage.toString())
//                }
//
//            })
//        })
//    }

}