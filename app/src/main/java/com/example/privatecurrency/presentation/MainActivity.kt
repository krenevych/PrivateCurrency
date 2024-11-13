package com.example.privatecurrency.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.privatecurrency.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.fetchData()
        }

        viewModel.liveData.observe(this) {
            Log.d(TAG, "onCreate: $it")

            if (it == null || it.isEmpty()) {
                return@observe
            }
            with(binding) {
                it[0].let { currency ->
                    ccy.text = currency.ccy
                    baseCcy.text = currency.baseCcy
                    buy.text = currency.buy
                    sale.text = currency.sale
                }
            }


        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.fetchData()
    }

    val TAG = "XXXXX"
}