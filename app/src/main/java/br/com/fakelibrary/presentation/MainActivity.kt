package br.com.fakelibrary.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fakelibrary.R
import br.com.fakelibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val layoutContainer by lazy {
        MainActivityLayoutContainer(
            containerView = binding.root,
            binding = binding
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }
    private fun initViews(){
        layoutContainer.initLayout()
    }
}