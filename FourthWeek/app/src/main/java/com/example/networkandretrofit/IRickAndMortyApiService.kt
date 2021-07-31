package com.example.networkandretrofit

import android.telecom.Call
import com.example.networkandretrofit.models.core.Character
import com.example.networkandretrofit.models.listing.RickAndMortyBaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRickAndMortyApiService {
    @GET("/character")
    fun listCharacters(@Query("page") page:Int): Call<RickAndMortyBaseResponse>

    @GET("/character/{id}")
    fun getlistCharacter(@Path("id")id:Int):Call<Character>
}