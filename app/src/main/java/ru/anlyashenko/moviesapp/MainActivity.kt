package ru.anlyashenko.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.anlyashenko.moviesapp.navigation.Screen
import ru.anlyashenko.moviesapp.screens.IntroScreen
import ru.anlyashenko.moviesapp.screens.LoginScreen
import ru.anlyashenko.moviesapp.ui.theme.MoviesAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            MoviesAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {
        composable(Screen.Intro.route) {
            IntroScreen(
                onGetInClick = { navController.navigate(Screen.Login.route) }
            )
        }

        composable(Screen.Login.route) {
            LoginScreen(
                onLoginClick = { navController.navigate(Screen.Login.route) }
            )
        }
    }
}
