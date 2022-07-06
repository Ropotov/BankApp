package ru.nikita.bankapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ListCard(var cards: List<Card>)

@Parcelize
data class Card(
    var id: String,
    var number: String,
    var sum: String,
    var type: String
) : Parcelable