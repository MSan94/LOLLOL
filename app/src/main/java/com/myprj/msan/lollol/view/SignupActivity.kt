package com.myprj.msan.lollol.view

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.myprj.msan.lollol.R

class SignupActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var editTextInputId : EditText
    private lateinit var editTextInputPw : EditText
    private val appCompatButtonSignUpSuccess : AppCompatButton by lazy { findViewById(R.id.appCompatButtonSignUpSuccess) }
    private val appCompatButtonCancel : AppCompatButton by lazy { findViewById(R.id.appCompatButtonCancel) }
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = Firebase.auth

        /**
         * 등록버튼 & 취소버튼
         */
        appCompatButtonSignUpSuccess.setOnClickListener {
            setOnClickListener_AppCompatButton(appCompatButtonSignUpSuccess)
        }
        appCompatButtonCancel.setOnClickListener {
            setOnClickListener_AppCompatButton(appCompatButtonCancel)
        }


    }

    private fun setOnClickListener_AppCompatButton(button : AppCompatButton){
        when(button.id){
            R.id.appCompatButtonSignUpSuccess -> {
                editTextInputId = findViewById(R.id.editTextInputId)
                editTextInputPw = findViewById(R.id.editTextInputPw)
                val email = editTextInputId.text.toString()
                val password = editTextInputPw.text.toString()
                if(email.length < 5 || password.length < 5){
                    Toast.makeText(this,"회원정보를 올바르게 입력해주세요.", Toast.LENGTH_SHORT).show()
                    return
                }else{
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this) {
                            if(it.isSuccessful){
                                Toast.makeText(this,"회원가입 완료", Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(this,"${it.result}장애발생", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
            R.id.appCompatButtonCancel -> {
                Toast.makeText(this,"취소", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

}