package br.com.fakelibrary.presentation.home

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fakelibrary.core.extensions.shimmerVisibility
import br.com.fakelibrary.core.extensions.toast
import br.com.fakelibrary.databinding.ActivityMainBinding
import br.com.fakelibrary.presentation.home.adapter.FakeBookAdapter
import br.com.fakelibrary.presentation.home.model.FakeBookStates
import kotlinx.android.extensions.LayoutContainer

/**
 * @author RubioAlves
 * Created 27/11/2021 at 08:53
 */
class FakeLibraryActivityLayoutContainer(
    override val containerView: View,
    private val binding: ActivityMainBinding,
    private val viewModel: FakeLibraryViewModel,
    private var fakeBookAdapter: FakeBookAdapter,
    private val activity: FakeLibraryActivity
):LayoutContainer{

    private fun initLayout() = with(binding){
        with(rvFakeBooks){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = fakeBookAdapter
            setHasFixedSize(true)
        }
    }

    fun initViewModel(){
        viewModel.getQuantityFakeBook(1)
        viewModel.state.observe(activity){ states->
            with(states){
                when(this){
                    is FakeBookStates.Error -> {
                        message.toast(containerView.context)
                        binding.shimmerFrameLayout.shimmerVisibility()
                    }
                    is FakeBookStates.Sucess -> {
                        response?.let { datas->
                            fakeBookAdapter = FakeBookAdapter(datas.data)
                            shimmerVisible()
                            initLayout()
                        }
                    }
                }
            }
        }
    }
    private fun shimmerVisible(){
        binding.apply {
            shimmerFrameLayout.stopShimmerAnimation()
            shimmerFrameLayout.shimmerVisibility()
            rvFakeBooks.visibility = View.VISIBLE
        }
    }
}