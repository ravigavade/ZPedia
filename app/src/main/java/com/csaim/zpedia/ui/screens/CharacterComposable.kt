package com.csaim.zpedia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.csaim.zpedia.viewModel.CharacterViewModel

@Composable
fun CharacterComposebale(navController: NavController,viewModel: CharacterViewModel = viewModel()) {

    val CharacterList by viewModel.characters.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    LazyColumn(

        modifier = Modifier
//            .padding(16.dp)
            .fillMaxSize()
            .background(Color(0xFFE7E5EB))
            .statusBarsPadding()
    ) {
        items(CharacterList.chunked(2)){ rowItems ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { character ->
                    Card(
                        modifier = Modifier
                            .weight(1f) // equally divide space
                            .padding(bottom = 16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFe76a24)
                        )


                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            AsyncImage(
                                model = character.image,
                                contentDescription = "image",
                                modifier = Modifier
                                    .height(250.dp)
                                    .fillMaxWidth()
                            )
                            Text(
                                modifier = Modifier
                                    .fillParentMaxWidth(),
                                text = character.name,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }


}