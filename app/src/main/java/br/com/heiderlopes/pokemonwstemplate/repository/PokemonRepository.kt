package br.com.heiderlopes.pokemonwstemplate.repository

interface PokemonRepository {
    fun checkHealth(
        onComplete: () -> Unit,
        onError: (Throwable?) -> Unit
    )
}