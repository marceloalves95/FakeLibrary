package br.com.fakelibrary.presentation.home.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import br.com.fakelibrary.databinding.FakeBookAdapterBinding
import br.com.fakelibrary.domain.Data
import com.bumptech.glide.Glide

/**
 * @author RubioAlves
 * Created 27/11/2021 at 18:02
 */
class FakeBookAdapter(private val lista: List<Data>) : RecyclerView.Adapter<FakeBookAdapter.FakeBookAdapterViewHolder>() {

    inner class FakeBookAdapterViewHolder(private val itemBinding: FakeBookAdapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: Data) = with(data){
            with(itemBinding){
                tvTitle.text = title
                tvAuthor.text = author
                tvGenre.text = genre
                tvPublished.text = published
                tvPublisher.text = publisher
                Glide.with(itemView.context).load(image).into(ivImage)
            }

        }

    }

    override fun onCreateViewHolder(
        parent: android.view.ViewGroup,
        viewType: Int
    ): FakeBookAdapterViewHolder {
        return FakeBookAdapterViewHolder(FakeBookAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FakeBookAdapterViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

}