package ru.nikita.bankapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.nikita.bankapp.R
import ru.nikita.bankapp.cardType
import ru.nikita.bankapp.databinding.FragmentDetailCardBinding
import ru.nikita.bankapp.model.Card
import ru.nikita.bankapp.percent
import ru.nikita.bankapp.replaceString

class DetailCardFragment : Fragment() {

    lateinit var binding: FragmentDetailCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val card = arguments?.getParcelable<Card>("Card") as Card

        with(binding) {
            cardFullNumber.text = replaceString(card.number)
            cardBalance.text = card.sum
            cardType.text = cardType(card.type.toInt(), requireContext())
            percentageOnBalance.text = percent(card.sum.toDouble())
            btnBack.setOnClickListener {
                findNavController().popBackStack(R.id.cardListFragment, false)
            }
        }
    }
}