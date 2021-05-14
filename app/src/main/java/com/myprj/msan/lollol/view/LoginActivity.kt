package com.myprj.msan.lollol.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.myprj.msan.lollol.R

class LoginActivity : AppCompatActivity() {
    private val appCompatButtonSignIn : AppCompatButton by lazy { findViewById(R.id.appCompatButtonSignIn) }
    private val appCompatButtonSignUp : AppCompatButton by lazy { findViewById(R.id.appCompatButtonSignUp) }
    private val appCompatButtonGuest : AppCompatButton by lazy { findViewById(R.id.appCompatButtonGuest) }
    private val editTextInputId : EditText by lazy { findViewById(R.id.editTextInputId) }
    private val editTextInputPw : EditText by lazy { findViewById(R.id.editTextInputPw) }

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        /**
         * 로그인, 회원가입, 게스트로그인 버튼 이벤트
         */
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

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
    /**
     * 버튼 클릭 처리 메서드
     */
    private fun setOnClickListener_AppCompatButton(button : AppCompatButton) : Unit{
        when(button.id){
            R.id.appCompatButtonSignIn -> {
                //todo 파이어베이스 인증
                val email = editTextInputId.text.toString()
                val password = editTextInputPw.text.toString()
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        Toast.makeText(this,"계정 정보를 확인해주세요.", Toast.LENGTH_SHORT).show()
                        return@addOnCompleteListener
                    }
                }
            }
            R.id.appCompatButtonSignUp -> {
                startActivity(Intent(this,SignupActivity::class.java))
            }
            R.id.appCompatButtonGuest -> {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }


}