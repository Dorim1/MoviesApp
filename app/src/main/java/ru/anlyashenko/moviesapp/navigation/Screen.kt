package ru.anlyashenko.moviesapp.navigation

sealed class Screen(val route: String) {
    object Intro : Screen("intro")
    object Login : Screen("login")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Support : Screen("support")
    object Settings : Screen("settings")
}