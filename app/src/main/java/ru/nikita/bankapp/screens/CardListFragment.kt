package ru.nikita.bankapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.bankapp.R
import ru.nikita.bankapp.databinding.FragmentCardListBinding
import ru.nikita.bankapp.model.Card
import ru.nikita.bankapp.screens.adapter.CardListAdapter

class CardListFragment : Fragment() {

    private lateinit var binding: FragmentCardListBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CardListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        recyclerView = binding.recyclerView
        adapter = CardListAdapter()
        recyclerView.adapter = adapter
        viewModel.getCard()
        viewModel.myCardList.observe(viewLifecycleOwner, { response ->
            response.body()?.cards?.let { adapter.cardList = it }
        })
    }

    override fun onResume() {
        super.onResume()
        adapter.onCardClickListener = object : CardListAdapter.OnCardClickListener {
            override fun onCardClick(item: Card) {
                super.onCardClick(item)
                val bundle = Bundle()
                bundle.putParcelable("Card", item)
                findNavController().navigate(
                    R.id.action_cardListFragment_to_detailCardFragment,
                    bundleOf("Card" to item)
                )
            }
        }
    }
}