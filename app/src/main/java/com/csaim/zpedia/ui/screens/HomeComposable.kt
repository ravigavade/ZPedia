package com.csaim.zpedia.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.csaim.zpedia.R
import com.csaim.zpedia.ui.theme.DBZFont


@Composable
fun HomeComposable(navController: NavController) {


    //entire screen
    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        //bg image
        AsyncImage(
            model = R.drawable.bg4,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        //front ui part
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // dbz logo + Zpedia
            Box(
                modifier = Modifier
            ){
                AsyncImage(
                    model = R.drawable.dbzlogo,
                    contentDescription = ""
                )
                Text(
                    "Welcome to ZPedia!",
                    fontFamily = DBZFont,
                    color = Color.White,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 100.dp)
                )
            }


            //featured Z fighters card
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(130.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD6061C)
                ),

            ) {
                //entire card as a row
                Row {
                    // the text column
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {

                        Text(
                            " \uD83D\uDD25 Featured \n    Z Fighters",
                            fontSize = 24.sp,
                            color = Color(0xFFF4E809),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 16.dp, start = 8.dp)
                        )

                        // view details card btn
                        Card(
                            modifier = Modifier

                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF4E809)
                            ),
                            onClick = {
                                //navigate to zfighters screen
                            }
                        ) {
                            Text(
                                "View Details",
                                modifier = Modifier
                                    .padding(4.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .padding(horizontal = 8.dp),
                                fontWeight = FontWeight.Bold,

                            )
                        }
                    }

                    //img part
                    Column (
                        modifier = Modifier
                            .weight(1f)
                    ){
                        AsyncImage(
                            model = R.drawable.zf,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(20.dp))


            // 3 blocks layer
            Row(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // brows char card
                Card(
                    modifier = Modifier
//                        .padding(16.dp)
                        .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(12.dp))
                        .height(100.dp)
                        .weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF062B68)
                    ),
                    onClick = {
                        //navigate to Character list screen
                        navController.navigate("CharacterScreen")
                    }


                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Browse\nCharacters",
                            modifier = Modifier
                                .padding(16.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF4E809),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center


                        )
                    }

                }

                // by race card
                Card(
                    modifier = Modifier
//                        .padding(16.dp)
                        .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(12.dp))
                        .height(100.dp)
                        .fillMaxHeight()
                        .weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF032B6B)
                    ),
                    onClick = {
                        //navigate to by race screen
                    }

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "By\nRace",
                            modifier = Modifier
//                                .fillMaxSize()
                                .padding(16.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF4E809),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                }


                //By Affiliation card
                Card(
                    modifier = Modifier
//                        .padding(16.dp)
                        .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(12.dp))
                        .height(100.dp)
                        .weight(1f),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF032B6B)
                    ),
                    onClick = {
                        //navigate to by affilation screen
                    }

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                        ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            " by \n Affiliation",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF4E809),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                }



            }



        }

    }

}