package com.example.privatecurrency

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.privatecurrency.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            // TODO:
            val url = URL("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5")

            lifecycleScope.launch {
                val text = withContext(Dispatchers.IO) {
                    url.readText(Charset.defaultCharset())
                }

                Log.d(TAG, "text: $text")
            }

        }
    }

    val TAG = "XXXXX"
}