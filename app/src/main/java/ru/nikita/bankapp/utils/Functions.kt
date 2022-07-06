package ru.nikita.bankapp

import android.content.Context
import okhttp3.internal.format

fun replaceString(string: String): String {
    var list: List<String> = string.chunked(4)
    return list[0] + " " + list[1] + " " + list[2] + " " + list[3] + " "
}

fun cardType(int: Int, context: Context): String {
    return if (int == 0) {
        context.getString(R.string.card_type_debet)
    } else {
        context.getString(R.string.card_type_credit)
    }
}

fun percent(double: Double): String {
    return format("%.2f",double * 0.06 / 12)
}