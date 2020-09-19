package br.com.heiderlopes.pokemonwstemplate.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokemonwstemplate.model.Pokemon
import br.com.heiderlopes.pokemonwstemplate.model.RequestState
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepository

class DetailViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemonsResponse = MutableLiveData<RequestState<Pokemon?>>()

    fun getPokemon(number: String) {
        pokemonsResponse.value = RequestState.Loading

        pokemonRepository.getPokemon(
            number,
            onComplete = {
                pokemonsResponse.value = RequestState.Success(it)
            },
            onError = {
                pokemonsResponse.value = RequestState.Error(it)
            }
        )
    }
}
