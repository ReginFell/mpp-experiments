package com.regin.additivefood

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.regin.additive.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class ConsumerActivity : AppCompatActivity() {

    private val api: Api by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {

            val result = api.about().await()

            withContext(Dispatchers.Main) {
                Toast.makeText(this@ConsumerActivity, result, Toast.LENGTH_LONG).show()
            }
        }
    }
}