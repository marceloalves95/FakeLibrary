package br.com.fakelibrary.core.extensions

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.facebook.shimmer.ShimmerFrameLayout

/**
 * @author RubioAlves
 * Created 27/11/2021 at 21:03
 */
fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(context, this.toString(), duration).apply { show() }
}
fun ShimmerFrameLayout.shimmerVisible(isVisible:Boolean){
    this.isVisible = isVisible
    if (isVisible){
        startShimmerAnimation()
    }else{
        stopShimmerAnimation()
    }
}