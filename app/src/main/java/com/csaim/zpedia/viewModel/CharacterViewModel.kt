package com.csaim.zpedia.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.zpedia.data.model.Character
import com.csaim.zpedia.data.model.CharacterResponse
import com.csaim.zpedia.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel:ViewModel() {

    val repository = CharacterRepository()

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters : StateFlow<List<Character>> = _characters


    // this fun will return the characters
    fun fetchCharacters(){
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characters.value = response
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}