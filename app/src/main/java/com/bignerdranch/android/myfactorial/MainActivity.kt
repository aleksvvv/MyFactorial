package com.bignerdranch.android.myfactorial

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.myfactorial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observe()
        binding.button.setOnClickListener {
            viewModel.calculate(binding.inputNumber.text.toString())
        }
    }

    fun observe() {

        viewModel.progress.observe(this) {
          if (it){
              binding.progressBar.visibility = View.VISIBLE
              binding.button.isEnabled = false
          } else{
              binding.progressBar.visibility = View.GONE
              binding.button.isEnabled = true
          }
        }
        viewModel.error.observe(this){
            if (it){
                Toast.makeText(
                    this,"Input empty",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.factorial.observe(this){
            binding.tvFactorial.text = it
        }

    }
}