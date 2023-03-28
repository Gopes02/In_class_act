package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView by lazy {
            findViewById(R.id.Timer)
        }
        val button: Button by lazy {
            findViewById(R.id.button)
        }

        val scope = CoroutineScope(Job() + Dispatchers.Default)
        button.setOnClickListener() {
            scope.launch {
                repeat(100) {
                    (100 - it).toString().run {
                        Log.d("Countdown", this)
                        withContext(Dispatchers.Main) { textView.text = this@run }
                    }
                    delay(1000)
                }
            }
        }

    }
}