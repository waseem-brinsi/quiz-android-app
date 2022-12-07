package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private var btnStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart =findViewById(R.id.btnStart)
        btnStart?.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)

            if (etName.text.toString().isEmpty()){
                Toast.makeText(this,"Plase Enter your Name",Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(ListofQuestion.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}