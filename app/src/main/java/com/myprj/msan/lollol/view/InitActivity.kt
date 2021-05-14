package com.myprj.msan.lollol.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.myprj.msan.lollol.R

class InitActivity : AppCompatActivity() {
    private val appCompatButtonSignIn : AppCompatButton by lazy { findViewById(R.id.appCompatButtonSignIn) }
    private val appCompatButtonSignUp : AppCompatButton by lazy { findViewById(R.id.appCompatButtonSignUp) }
    private val appCompatButtonGuest : AppCompatButton by lazy { findViewById(R.id.appCompatButtonGuest) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        appCompatButtonSignIn.setOnClickListener {
            setOnClickListener_AppCompatButton(appCompatButtonSignIn)
        }

        appCompatButtonSignUp.setOnClickListener {
            setOnClickListener_AppCompatButton(appCompatButtonSignUp)
        }

        appCompatButtonGuest.setOnClickListener {
            setOnClickListener_AppCompatButton(appCompatButtonGuest)
        }
    }

    private fun setOnClickListener_AppCompatButton(button : AppCompatButton) : Unit{
        when(button.id){
            R.id.appCompatButtonSignIn -> {
                //todo 파이어베이스 인증
            }
            R.id.appCompatButtonSignUp -> {
                //todo 회원가입 프래그먼트
            }
            R.id.appCompatButtonGuest -> {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }

}