package com.csaim.zpedia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csaim.zpedia.ui.screens.CharacterComposable
import com.csaim.zpedia.ui.screens.CharacterDetails

@Composable
fun SetupNavGraph(){

    val navController = rememberNavController()

    NavHost(navController, startDestination = "CharacterScreen" ){

        composable("CharacterScreen"){
            CharacterComposable(navController)
        }

//        composable("CharacterDetails"){
//            CharacterDetails(navController)
//        }

        composable("CharacterDetails/{id}"){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""

            CharacterDetails(
                navController = navController,
                id = id.toInt()
            )
        }

    }

}