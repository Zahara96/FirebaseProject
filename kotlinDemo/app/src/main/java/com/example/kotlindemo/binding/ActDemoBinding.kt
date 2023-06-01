package com.example.kotlindemo.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.databinding.ActDemoBindingBinding


class ActDemoBinding : AppCompatActivity() {
    lateinit var binding: ActDemoBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActDemoBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}