package com.regin.additivefood

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.regin.additive.core.SharedClass

class ConsumerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, SharedClass().test(), Toast.LENGTH_LONG).show()
    }
}