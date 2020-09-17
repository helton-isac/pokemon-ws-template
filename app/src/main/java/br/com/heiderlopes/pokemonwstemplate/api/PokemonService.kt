package br.com.heiderlopes.pokemonwstemplate.api

import br.com.heiderlopes.pokemonwstemplate.model.HealthResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>
}