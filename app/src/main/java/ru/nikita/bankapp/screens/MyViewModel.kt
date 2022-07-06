package ru.nikita.bankapp.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.nikita.bankapp.api.RetrofitInstance
import ru.nikita.bankapp.model.ListCard

class MyViewModel : ViewModel() {
    var myCardList: MutableLiveData<Response<ListCard>> = MutableLiveData()

    fun getCard() {
        viewModelScope.launch {
            myCardList.value = RetrofitInstance.api.getCard()
        }
    }
}