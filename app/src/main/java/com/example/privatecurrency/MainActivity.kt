package com.example.privatecurrency

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.privatecurrency.databinding.ActivityMainBinding
import com.example.privatecurrency.retrofit.RetrofitObject
import com.example.privatecurrency.retrofit.RetrofitPrivate

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.fetchData()
        }

        viewModel.currencyList.observe(this) {
            Log.d(TAG, "onCreate: $it")
        }
    }

    val TAG = "XXXXX"
}