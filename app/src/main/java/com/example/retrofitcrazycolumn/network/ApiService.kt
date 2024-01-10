package com.example.retrofitcrazycolumn.network

import com.example.retrofitcrazycolumn.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>  //funcion asincrona


    companion object {  //es un objeto que es común a todas las instancias de esa clase
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}