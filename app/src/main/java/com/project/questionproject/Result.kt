package com.project.questionproject

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activit_view_score.*

class Result:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activit_view_score)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        val username = intent.getStringExtra("UserName")
        val score = intent.getStringExtra("Score")
        val totalQuestions = intent.getStringExtra("total size");

        congo.text = "Congratulations ${username} !!"
        Score.text = "${score} / ${totalQuestions}"




    }
}