package com.example.networkandretrofit

import android.util.Log
import com.example.networkandretrofit.models.listing.RickAndMortyBaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitHelper {
    var retrofit: Retrofit =Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service:IRickAndMortyApiService=retrofit.create(IRickAndMortyApiService::class.java)

    fun listCharacter(page:Int=1){
        service.listCharacters(page).enqueue(object : Callback<RickAndMortyBaseResponse> {
            override fun onResponse(
                call: Call<RickAndMortyBaseResponse>,
                response: Response<RickAndMortyBaseResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        it.characters.forEach { character ->
                            Log.v("RetrofitHelper","${character.name}")
                        }
                    }
                }else{
                    Log.v("RetrofitHelper","any errors.")
                }

            }

            override fun onFailure(call: Call<RickAndMortyBaseResponse>, t: Throwable) {
                Log.v("RetrofitHelper","onFailure->service unavailable errors.")
            }

        })
    }

}