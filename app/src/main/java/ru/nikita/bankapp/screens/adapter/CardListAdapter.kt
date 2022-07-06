package ru.nikita.bankapp.screens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.bankapp.databinding.ItemCardBinding
import ru.nikita.bankapp.model.Card

class CardListAdapter : RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

    var onCardClickListener: OnCardClickListener? = null

    var cardList: List<Card> = listOf()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Card) {
            val numberCard = position.number.substring(position.number.length - 4)
            with(binding) {
                cardNumber.text = "** $numberCard"
                cardBalance.text = position.sum
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cardList[position])
        holder.itemView.setOnClickListener {
            onCardClickListener?.onCardClick(cardList[position])
        }
    }

    override fun getItemCount(): Int = cardList.size

    interface OnCardClickListener {
        fun onCardClick(item: Card) {

        }
    }
}