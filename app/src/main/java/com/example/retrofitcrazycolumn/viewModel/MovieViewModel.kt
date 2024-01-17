package com.example.retrofitcrazycolumn.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcrazycolumn.model.Movie
import com.example.retrofitcrazycolumn.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var error: Boolean by mutableStateOf(false)
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
                error = false
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                error = true
            }
        }
    }

    fun getErrorCon():Boolean=error
}