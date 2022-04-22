package com.adl.ujianadlretrofit

import android.content.Intent
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

        btnLogin.setOnClickListener({
        LoginConfig().getLogin().getAllLogin("filter=&field=&start=&limit=&filters[0][co][0][fl]=username&filters[0][co][0][op]=equal&filters[0][co][0][vl]=&filters[0][co][0][lg]=${txtUsername.text.toString()}&filters[0][co][1][fl]=password&filters[0][co][1][op]=equal&filters[0][co][1][vl]=${txtPassword.text.toString()}").enqueue(object :Callback<GetLoginUserResponse>{
            override fun onResponse(
                call: Call<GetLoginUserResponse>,
                response: Response<GetLoginUserResponse>
            ) {
                Log.d("Response",response.body().toString())
                val dataLogin: GetLoginUserResponse? = response.body()
                Toast.makeText(this@LoginActivity,"success", Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                startActivity(intent)
            }

            override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity,"error", Toast.LENGTH_LONG).show()
            }

        })

    })

    }


}