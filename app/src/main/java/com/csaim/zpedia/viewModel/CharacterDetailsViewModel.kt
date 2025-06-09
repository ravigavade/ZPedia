package com.csaim.zpedia.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.zpedia.data.model.CharacterDetailsResponse
import com.csaim.zpedia.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel: ViewModel() {

    val repository = CharacterRepository()

    private val _details = MutableStateFlow<CharacterDetailsResponse?>(null)
    val details: StateFlow<CharacterDetailsResponse?> =_details

    fun fetchDetails(id: Int){
        viewModelScope.launch {
            try {
                val response = repository.getCharacterDetails(id)
                _details.value = response
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}