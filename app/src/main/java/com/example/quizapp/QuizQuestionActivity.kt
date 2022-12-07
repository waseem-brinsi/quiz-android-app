package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener{
    @SuppressLint("MissingInflatedId")
    private var answer:Int = 0
    private var index:Int = 0
    private var progressVal = 10
    private var allquestion = ListofQuestion.getlist();
    private var mUSER_NAME : String? = null
    private var mCorrectAnswer : Int = 10

    private var tvQuestion:TextView? =null
    private var imgvCountry:ImageView? =null
    private var progressBar:ProgressBar? =null
    private var tvProgress:TextView? =null
    private var tvQuestion1:TextView? =null
    private var tvQuestion2:TextView? =null
    private var tvQuestion3:TextView? =null
    private var tvQuestion4:TextView? =null
    private var btnSubmit:Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

       //start code

        mCorrectAnswer=allquestion.size
        mUSER_NAME = intent.getStringExtra(ListofQuestion.USER_NAME)

        tvQuestion = findViewById(R.id.tvQuestion)
        imgvCountry= findViewById(R.id.imgvCountry)
        progressBar= findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion1 = findViewById(R.id.tvQuestion1)
        tvQuestion2 = findViewById(R.id.tvQuestion2)
        tvQuestion3 = findViewById(R.id.tvQuestion3)
        tvQuestion4 = findViewById(R.id.tvQuestion4)
        btnSubmit = findViewById(R.id.btnSubmit)


        tvQuestion1?.setOnClickListener(this)
        tvQuestion2?.setOnClickListener(this)
        tvQuestion3?.setOnClickListener(this)
        tvQuestion4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        SetQuestion()
        defaultOptionView()

    }

    private fun SetQuestion() {
        //default value sitting:
        tvQuestion?.text = allquestion[index].question
        imgvCountry?.setImageResource(allquestion[index].image)
        progressBar?.progress = progressVal
        val Questnum = index + 1
        tvProgress?.text = "$Questnum/10"
        tvQuestion1?.text = allquestion[index].optionOne
        tvQuestion2?.text = allquestion[index].optionTow
        tvQuestion3?.text = allquestion[index].optionThree
        tvQuestion4?.text = allquestion[index].optionFour
    }

    private fun defaultOptionView(){
        val  options = ArrayList<TextView>()
        tvQuestion1?.let{
                options.add(0,it)
        }
        tvQuestion2?.let{
            options.add(1,it)
        }
        tvQuestion3?.let{
            options.add(2,it)
        }
        tvQuestion4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#FF0000"))
            option.background = ContextCompat.getDrawable(this,R.drawable.option_bg)
        }
    }
    private fun selectedOption(tvQuestion:TextView? ,answerVal:Int){
        tvQuestion?.background = ContextCompat.getDrawable(this,R.drawable.select_option_bg)
        answer = answerVal
    }

    override fun onClick(myview: View?) {
        when(myview?.id){
            R.id.tvQuestion1->{
                defaultOptionView()
                tvQuestion1?.let{
                    selectedOption(tvQuestion1,1)
                }
            }
            R.id.tvQuestion2->{
                defaultOptionView()
                tvQuestion2?.let{
                    selectedOption(tvQuestion2,2)
                }
            }
            R.id.tvQuestion3->{
                defaultOptionView()
                selectedOption(tvQuestion3,3)
            }
            R.id.tvQuestion4->{
                defaultOptionView()
                selectedOption(tvQuestion4,4)
            }
            R.id.btnSubmit->{

                if (index < allquestion.size){
                    if (answer == 0){
                        btnSubmit?.text= "submit"
                        defaultOptionView()
                        SetQuestion()
                        println(allquestion.size)
                    }
                    else{
                        defaultOptionView()
                        if(allquestion[index].correctAnswer != answer){
                            answerView(answer,R.drawable.wrong_bg)
                            mCorrectAnswer -= 1
                        }
                        answerView(allquestion[index].correctAnswer,R.drawable.correct_bg)
                        btnSubmit?.text= "Go to the next Option"
                        index++
                        progressVal+=10
                        answer = 0

                    }
                }
                else{
                    btnSubmit?.text="Finish"
//                    Toast.makeText(this, "Quiz is Finished", Toast.LENGTH_SHORT).show()
                    defaultOptionView()

                    val intent = Intent(this,ResaultActivity::class.java)
                    println(mUSER_NAME)
                    println(mCorrectAnswer)
                    println(allquestion.size)
                    intent.putExtra(ListofQuestion.USER_NAME,mUSER_NAME)
                    intent.putExtra(ListofQuestion.CORRECT_ANSWER,mCorrectAnswer.toString())
                    intent.putExtra(ListofQuestion.TOTAL_QUESTION,allquestion.size.toString())
                    startActivity(intent)
                    finish()

                }
            }
        }
    }
    private fun answerView(answer:Int,drawbaleView:Int){
        when(answer){
            1->{
                tvQuestion1?.background = ContextCompat.getDrawable(this,drawbaleView)
            }
            2->{
                tvQuestion2?.background = ContextCompat.getDrawable(this,drawbaleView)
            }
            3->{
                tvQuestion3?.background = ContextCompat.getDrawable(this,drawbaleView)
            }
            4->{
                tvQuestion4?.background = ContextCompat.getDrawable(this,drawbaleView)
            }
        }
    }
}