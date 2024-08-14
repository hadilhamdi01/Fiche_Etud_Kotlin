package com.example.ficheetudiant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name=intent.getStringExtra ("data")
        // test name
        val textView5=findViewById<TextView>(R.id.txt).apply {
            text= "$name"
        }
        button=findViewById(R.id.shareButton)
        val url = "https://youtu.be/56GMwP9ppjdk"
        button.setOnClickListener {val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra("share this",url)
            val chooser =Intent.createChooser(intent,"share using ...")
            startActivity(chooser)

        }
    }
}