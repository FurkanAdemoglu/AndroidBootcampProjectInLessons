package com.example.networkandretrofit.models.listing


import com.example.networkandretrofit.models.core.Character
import com.google.gson.annotations.SerializedName

data class RickAndMortyBaseResponse(
    @SerializedName("info")
    val info: İnfo,
    @SerializedName("results")
    val characters: List<Character>
)