package br.com.fakelibrary.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.fakelibrary.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FakeLibraryActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel:FakeLibraryViewModel by viewModel()
    private val adapter:FakeBookAdapter by lazy { FakeBookAdapter(emptyList()) }

    private val layoutContainer by lazy {
        FakeLibraryActivityLayoutContainer(
            containerView = binding.root,
            binding = binding,
            viewModel = viewModel,
            fakeBookAdapter = adapter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        initViewModel()

    }
    private fun initViews(){
        layoutContainer.initLayout()
    }
    private fun initViewModel(){
        lifecycleScope.launchWhenStarted {
            layoutContainer.initViewModel()
        }
    }
}