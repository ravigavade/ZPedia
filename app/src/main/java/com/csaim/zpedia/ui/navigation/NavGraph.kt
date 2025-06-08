package com.csaim.zpedia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csaim.zpedia.ui.screens.CharacterComposebale

@Composable
fun SetupNavGraph(){

    val navController = rememberNavController()

    NavHost(navController, startDestination = "CharacterScreen" ){

        composable("CharacterScreen"){
            CharacterComposebale(navController)
        }

    }

}