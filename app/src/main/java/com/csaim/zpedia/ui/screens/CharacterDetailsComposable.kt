package com.csaim.zpedia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.csaim.zpedia.ui.theme.DBZFont
import com.csaim.zpedia.viewModel.CharacterDetailsViewModel

@Composable
fun CharacterDetails(
    navController: NavController,
    id: Int,
    viewModel: CharacterDetailsViewModel = viewModel()
) {

    //geting from vm
    val details by viewModel.details.collectAsState()

    //fetching details once the comp is launched
    LaunchedEffect(Unit) {
        viewModel.fetchDetails(id)
    }


    //entire frame
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        //bg image
        AsyncImage(
            model = com.csaim.zpedia.R.drawable.bg,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.8f
        )
        //character image
        Box(
            modifier = Modifier
                .fillMaxSize(), // takes all card space
            contentAlignment = Alignment.Center // centers the image
        ) {

//                    AsyncImage(
//                        model = details?.originPlanet?.image,
//                        contentDescription = "",
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        contentScale = ContentScale.Crop,
//                        alpha = 0.5f
//                    )
            //img
            AsyncImage(
                model = details?.transformations?.randomOrNull()?.image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.85f,
                modifier = Modifier.fillMaxSize()


            )


        }
        //details starts from heare
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom

        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            ) {
                //character name
                details?.name?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 92.sp,
                        fontFamily = DBZFont,

                    )
                    //transformations
                    var selectedTransformation by remember {
                        mutableStateOf(details?.transformations?.randomOrNull())
                    }

                    LazyRow {
                       items(details?.transformations ?: emptyList()){ transformation ->
                        val isHighlighted = transformation.name == selectedTransformation?.name
                           Text(
                               text = transformation.name,
                               color = if (isHighlighted) Color.White else Color.White,
                               fontFamily =  FontFamily.Monospace,
                               fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal,
                               fontSize = if (isHighlighted) 14.sp else 12.sp,
                               modifier = Modifier
//                                   .background((if (isHighlighted) Color(0xFFE7E5EB) else Color.Transparent))
                                   .padding(end = 8.dp)

                           )
                       }
                   }

                    //character description
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE7E5EB)

                        ),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            details!!.description,
                            Modifier.padding(16.dp),
                            maxLines = 5,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

            }
            //race and affiliation
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 50.dp)
            ) {

                Text(
                    text = "race: ${details?.race}",
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp),
                    fontFamily =  FontFamily.Monospace

                )
                Text(
                    text = "affiliation: ${details?.affiliation}",
                    color = Color.White,
                    fontFamily =  FontFamily.Monospace,
                    modifier = Modifier
                        .padding(end = 8.dp)

                )
            }
        }
    }


}