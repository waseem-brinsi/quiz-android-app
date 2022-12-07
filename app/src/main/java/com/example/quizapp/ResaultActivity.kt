package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResaultActivity : AppCompatActivity() {
    private var mUSER_NAME:String? = null
    private var mCORRECT_ANSWER:String? = null
    private var mTOTAL_QUESTION:String? = null
    private var tvName:TextView? = null
    private var tvScore:TextView? = null




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resault)



        mUSER_NAME = intent.getStringExtra(ListofQuestion.USER_NAME)

        mCORRECT_ANSWER = intent.getStringExtra(ListofQuestion.CORRECT_ANSWER)
        mTOTAL_QUESTION = intent.getStringExtra(ListofQuestion.TOTAL_QUESTION)

        println(mCORRECT_ANSWER)
        println(mTOTAL_QUESTION)

        tvName = findViewById(R.id.tvname)
        tvScore = findViewById(R.id.tvscore)

        tvName?.text = mUSER_NAME

        tvScore?.text = "your Score is $mCORRECT_ANSWER of $mTOTAL_QUESTION"

        var btnFinish:Button = findViewById(R.id.btnFinish)
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }



    }
}