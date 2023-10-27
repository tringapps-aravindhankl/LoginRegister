package com.example.loginregister

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginButton: Button=findViewById(R.id.loginbutton)
        var registerButton: Button=findViewById(R.id.registerbutton);

        var Login=LoginFragment();
        var Register=RegisterFragment();



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,Login)
            commit()
        }

        loginButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container,Login)
                commit();
            }
        }

        registerButton.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container,Register)
                commit()
            }
        }


    }
}