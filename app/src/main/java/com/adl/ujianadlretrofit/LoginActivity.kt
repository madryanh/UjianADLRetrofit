package com.adl.ujianadlretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.ujianadlretrofit.model.GetLoginResponse
import com.adl.ujianadlretrofit.service.LoginConfig
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            login()
        }
    }
    fun login(){
        LoginConfig().getLogin().getAllLogin(txtUsername.text.toString()).enqueue(object: Callback<GetLoginResponse>{
            override fun onResponse(
                call: Call<GetLoginResponse>,
                response: Response<GetLoginResponse>
            ) {
                var data = response.body()?.data?.tabel

                if(response.isSuccessful){
                    Log.d("data","${data}")
                    if (data?.size == 0){
                        Toast.makeText(this@LoginActivity,"Please Login First",Toast.LENGTH_LONG).show()
                    }else{

                        var currentUser = response.body()?.data?.tabel?.get(0)
                        if(currentUser?.username == txtUsername.text.toString() && currentUser?.password == txtPassword.text.toString()){
                            Toast.makeText(this@LoginActivity,"Account Confirmed",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                            intent.putExtra("data", currentUser)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@LoginActivity,"Username or Password Wrong",Toast.LENGTH_LONG).show()
                        }

                    }
                }else{
                    Toast.makeText(this@LoginActivity,"username and password can't empty",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<GetLoginResponse>, t: Throwable) {

            }

        })

    }
}



