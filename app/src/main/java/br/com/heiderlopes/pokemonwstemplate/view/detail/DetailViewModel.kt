package br.com.heiderlopes.pokemonwstemplate.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokemonwstemplate.model.Pokemon
import br.com.heiderlopes.pokemonwstemplate.repository.PokemonRepository

class DetailViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val pokemon = MutableLiveData<Pokemon>()
    val messageError: MutableLiveData<String> = MutableLiveData()

    fun getPokemon(number: String) {
        isLoading.value = true
        pokemonRepository.getPokemon(
            number,
            onComplete = {
                isLoading.value = false
                pokemon.value = it
            },
            onError = {
                isLoading.value = false
            }
        )
    }
}
