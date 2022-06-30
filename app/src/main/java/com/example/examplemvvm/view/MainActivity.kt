 package com.example.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.model.QuoteModel
import com.example.examplemvvm.viewmodel.QuoteViewModel

 class MainActivity : AppCompatActivity() {
    //declarar el bindind
    private lateinit var binding:ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicialixar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        quoteViewModel.quoteModel.observe(this, Observer {currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tAuthor.text = currentQuote.author
        })

        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}