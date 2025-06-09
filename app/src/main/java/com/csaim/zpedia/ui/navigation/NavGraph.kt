package com.csaim.zpedia.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csaim.zpedia.ui.screens.CharacterComposable
import com.csaim.zpedia.ui.screens.CharacterDetails
import com.csaim.zpedia.ui.screens.HomeComposable

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SetupNavGraph(){

    val navController = rememberNavController()

    NavHost(navController, startDestination = "Home" ){

        composable("CharacterScreen"){
            CharacterComposable(navController)
        }

        composable("Home"){
            HomeComposable(navController)
        }


        composable("CharacterDetails/{id}"){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""

            CharacterDetails(
                navController = navController,
                id = id.toInt()
            )
        }

    }

}