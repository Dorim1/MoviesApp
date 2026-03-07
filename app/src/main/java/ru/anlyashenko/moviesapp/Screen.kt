package ru.anlyashenko.moviesapp

sealed class Screen(val route: String) {
    object Intro : Screen("intro")
    object Login : Screen("login")
}