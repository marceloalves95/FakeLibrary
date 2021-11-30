package br.com.fakelibrary.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fakelibrary.databinding.ActivityMainBinding
import br.com.fakelibrary.presentation.home.adapter.FakeBookAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FakeLibraryActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: FakeLibraryViewModel by viewModel()
    private val adapter: FakeBookAdapter by lazy { FakeBookAdapter(emptyList()) }

    private val layoutContainer by lazy {
        FakeLibraryActivityLayoutContainer(
            containerView = binding.root,
            binding = binding,
            viewModel = viewModel,
            fakeBookAdapter = adapter,
            activity = this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        binding.apply { shimmerFrameLayout.startShimmerAnimation() }
    }

    override fun onPause() {
        super.onPause()
        binding.apply { shimmerFrameLayout.stopShimmerAnimation() }
    }

    private fun initViewModel(){
        layoutContainer.initViewModel()
    }
}