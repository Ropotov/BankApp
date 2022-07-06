package ru.nikita.bankapp.api

import retrofit2.Response
import retrofit2.http.GET
import ru.nikita.bankapp.model.ListCard

interface ApiService {
    @GET("list.php/")
    suspend fun getCard(): Response<ListCard>
}