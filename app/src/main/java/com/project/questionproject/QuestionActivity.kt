package com.project.questionproject

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    var loginUsername:String? = null;
    private var questionArrayList:ArrayList<QuestionData> ? = null
    private var scoreArrayList:ArrayList<String> ? = null

    private var currentPosition:Int=1
    private var selecedOption:Int=0
    private var score:Int=0
  //  private var Name:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        loginUsername=intent.getStringExtra(setData.name)
        userName.setText("Welcome $loginUsername")

        questionArrayList = setData.getQuestion()
        setQuestion()

        opt_1.setOnClickListener {
            selectedOptionStyle(opt_1,1)
        }
      opt_2.setOnClickListener {
            selectedOptionStyle(opt_2,2)
        }
      opt_3.setOnClickListener {
            selectedOptionStyle(opt_3,3)
        }
      opt_4.setOnClickListener {
            selectedOptionStyle(opt_4,4)
        }
        submit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionArrayList!![currentPosition-1]
                if(selecedOption!=question.correct_ans)
                {
                    setColor(selecedOption,R.drawable.wrong_question_option)
                }else{
                    score++;

                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if(currentPosition==questionArrayList!!.size)
                    submit.text="View Score"
                else
                    submit.text="Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionArrayList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,Result::class.java)
                        intent.putExtra("UserName",loginUsername.toString())
                        intent.putExtra("Score",score.toString())
                        intent.putExtra("total size",questionArrayList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption=0
        }



    }
    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun selectedOptionStyle(view: TextView, opt:Int){

        setOptionStyle()
        selecedOption=opt
        view.background= ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun setQuestion(){

        val question = questionArrayList!![currentPosition-1]
        setOptionStyle()


        progress_bar.progress=currentPosition
        progress_bar.max=questionArrayList!!.size
        progress_text.text="${currentPosition}"+"/"+"${questionArrayList!!.size}"
        question_text.text=question.question
        opt_1.text=question.option_one
        opt_2.text=question.option_tw0
        opt_3.text=question.option_three
        opt_4.text=question.option_four

    }

}