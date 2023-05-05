package com.nurlanamirzayeva.quizthecountry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.nurlanamirzayeva.quizthecountry.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    lateinit var binding: ActivityMain2Binding
    var quizCount=1
    var Quiz_Count=10
    var rightAnswerCount=0
    var rightAnswer:String?=null
    val quizData = mutableListOf(

        mutableListOf("Iceland","Reykjavík","Zagreb","Vilnius","Nuuk"),
        mutableListOf("Slovenia","Ljubljana","Tirana","Pristina","Paris"),
        mutableListOf("Vietnam","Hanoi","Phnom Penh","Ho Chi Minh City","Beijing"),
        mutableListOf("Turkmenistan","Ashgabat","La Paz","Samarkand","Dushanbe"),
        mutableListOf("Taiwan","Taipei","Moscow","Hong Kong","Seoul"),
        mutableListOf("Denmark","Copenhagen","Amsterdam","Brussels","Seoul"),
        mutableListOf("Croatia","Zagreb","Pristina","Ljubljana","Sarajevo"),
        mutableListOf("Iraq","Baghdad","Damascus","Mosul","Basra"),
        mutableListOf("Brazil","Brasília","Juba","Rio de Janeiro","Buenos Aires"),
        mutableListOf("Saudi Arabia","Riyadh","Dammam","Jeddah","Mecca"),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        showNextQuiz()
        quizData.shuffle()

    }

    fun showNextQuiz(){

        //Update countLabel
        binding.countLabel.text=getString(R.string.count_label,quizCount)


        //Pick one quiz set
        val quiz=quizData[0]

        //Set question & rightAnswer
        binding.questionLabel.text= " Which is the capital of ${quiz[0]}?"
        rightAnswer=quiz[1]
        quiz.removeAt(0)
        quiz.shuffle()

        //Set choices
        binding.answerBtn1.text=quiz[0]
        binding.answerBtn2.text=quiz[1]
        binding.answerBtn3.text=quiz[2]
        binding.answerBtn4.text=quiz[3]
        quizData.removeAt(0)


    }


    fun checkAnswer(view:View){

        // Get pushed button
        var answerBtn=findViewById<Button>(view.id)
        val btnText=answerBtn.text.toString()
        val alertTitle:String
        if(btnText==rightAnswer){
            alertTitle="Correct!"
            rightAnswerCount++

        }
        else{
            alertTitle="Wrong!"
        }
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("Answer:$rightAnswer")
            .setPositiveButton("OK"){dialogInterface,i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()

    }

    fun checkQuizCount(){
        if(quizCount==Quiz_Count){

            val intent= Intent(this,ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)
        }
        else{
            quizCount++
            showNextQuiz()

        }
    }

}
