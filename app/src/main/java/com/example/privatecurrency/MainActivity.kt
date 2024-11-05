package com.example.privatecurrency

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.privatecurrency.databinding.ActivityMainBinding
import com.example.privatecurrency.retrofit.RetrofitObject
import com.example.privatecurrency.retrofit.RetrofitPrivate

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            retrofitObject?.getCurrencyExchange {
                Log.d(TAG, "Currency: $it")

                it?.forEach{currency ->
                    Log.d(TAG, "$currency")
                }
            }

        }
    }

    private var retrofitObject: RetrofitPrivate? = null
    override fun onStart() {
        super.onStart()
        retrofitObject = RetrofitPrivate()
    }

    override fun onStop() {
        super.onStop()
        retrofitObject = null
    }

    val TAG = "XXXXX"
}