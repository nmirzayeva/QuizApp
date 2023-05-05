package com.nurlanamirzayeva.quizthecountry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.nurlanamirzayeva.quizthecountry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     var rightAnswer:String?=null
     var rightAnswerCount=0
     var quizCount=1
    val Quiz_Count=10
    val quizData= mutableListOf(
        mutableListOf("Azerbaijan", "Baku", "Ankara", "Havana", "Bern"),
        mutableListOf("Turkey", "Ankara", "Baku", "Havana", "Bern"),
        mutableListOf("United Kingdom", "London", "Paris", "Roma", "Singapore"),
        mutableListOf("Japan", "Tokyo", "Bangkok", "Taipei", "Jakarta"),
        mutableListOf("Italy", "Roma", "London", "Paris", "Havana"),
        mutableListOf("France", "Paris", "Ottawa", "Tokyo", "Bern"),
        mutableListOf("Spain", "Madrid", "Jakarta", "London", "Bern"),
        mutableListOf("Germany", "Berlin", "Copenhagen", "Havana", "Bern"),
        mutableListOf("Canada", "Ottawa", "Jakarta", "Rome", "Bern"),
        mutableListOf("Russia","Moscow","Bern","Kyiv","Ankara")

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
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
            intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount)
            startActivity(intent)

        }
        else{
            quizCount++
            showNextQuiz()

  }
    }

}
