package com.example.secondweekcodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var emailEditText:EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    lateinit var loginImageView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_chain_example)
        initViews()
        addListeners()


    }

    private fun initViews(){
        emailEditText=findViewById(R.id.emailEditText)
        passwordEditText=findViewById(R.id.passwordEditText)
        loginButton=findViewById(R.id.loginButton)
        loginImageView=findViewById(R.id.loginImageView)
        Glide.with(this)
            .load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.hurriyet.com.tr%2Fkelebek%2Ftelevizyon%2Fboru-filminin-konusu-ne-oyuncu-kadrosunda-kimler-var-41273482&psig=AOvVaw32dxxjIcaUMAavyE6gqawA&ust=1626543073141000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNCSvqOP6PECFQAAAAAdAAAAABAO")
            .into(loginImageView)
    }

    private fun addListeners(){
        emailEditText.addTextChangedListener{
            emailEditText.error=null
        }
        loginButton.setOnClickListener {
            val email=emailEditText.text.toString().trim()
            val password=passwordEditText.text.toString().trim()
            login(email,password)

        }
    }

    private fun login(email:String,password:String){
        if(email=="info@kodluyoruz.com"&&password=="123456"){
            Toast.makeText(baseContext,"Login is successful",Toast.LENGTH_SHORT).show()

        }else{
            emailEditText.error="Email is wrong"
        }
    }
}