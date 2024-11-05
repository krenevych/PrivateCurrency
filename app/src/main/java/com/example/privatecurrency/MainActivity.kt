package com.example.privatecurrency

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.privatecurrency.databinding.ActivityMainBinding
import com.example.privatecurrency.retrofit.RetrofitObject

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            retrofitObject?.getAndroid("7159a98ed69e3f84b62b") {
//            retrofitObject?.getAndroid("7159a98ed69e3f84b62b") {
                Log.d(TAG, "onResponse: $it")
            }

//            retrofitObject?.getOtherInfo() {
//                Log.d(TAG, "onResponse: $it")
//            }
        }
    }

    private var retrofitObject: RetrofitObject? = null
    override fun onStart() {
        super.onStart()
        retrofitObject = RetrofitObject()
    }

    override fun onStop() {
        super.onStop()
        retrofitObject?.onStop()
        retrofitObject = null
    }

    val TAG = "XXXXX"
}