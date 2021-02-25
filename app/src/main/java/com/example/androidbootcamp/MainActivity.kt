package com.example.androidbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //var btn1 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, HomePage::class.java)
            startActivity(intent)
        })

    }
}