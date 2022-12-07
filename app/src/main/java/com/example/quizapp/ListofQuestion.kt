package com.example.quizapp

object ListofQuestion {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answer"


    fun getlist():ArrayList<Question>{
        val QuesList = ArrayList<Question>()

        val Ques1 = Question(id = 1,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_argentina,"argentina",    "australia",
            "Armenia","Austria",1)
        QuesList.add(Ques1)

        val Ques2 = Question(id = 2,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_australia,"tunisia",    "australia",
            "algeria","argentina",2)
        QuesList.add(Ques2)
        val Ques3 = Question(id = 3,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_belgium,"brazil",    "australia",
            "Armenia","belgium",4)
        QuesList.add(Ques3)
        val Ques4 = Question(id = 4,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_brazil,"belgium",    "australia",
            "brazil","Austria",3)
        QuesList.add(Ques4)
        val Ques5 = Question(id = 5,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_denmark,"brazil",    "australia",
            "belgium","denmark",4)
        QuesList.add(Ques5)
        val Ques6 = Question(id = 6,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_fiji,"argentina",    "fiji",
            "Armenia","belgium",2)
        QuesList.add(Ques6)
        val Ques7 = Question(id = 7,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_germany,"germany",    "australia",
            "belgium","Austria",1)
        QuesList.add(Ques7)
        val Ques8 = Question(id = 8,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_india,"kuwait",    "belgium",
            "india","kuwait",3)
        QuesList.add(Ques8)
        val Ques9 = Question(id = 9,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,"argentina",    "australia",
            "kuwait","Austria",3)
        QuesList.add(Ques9)
        val Ques10 = Question(id = 10,"What country Does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,"zealand",    "australia",
            "germany","kuwait",1)
        QuesList.add(Ques10)

        return QuesList
    }


}