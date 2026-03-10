package ru.anlyashenko.moviesapp.screens.ui

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.anlyashenko.moviesapp.R
import ru.anlyashenko.moviesapp.navigation.Screen
import ru.anlyashenko.moviesapp.ui.theme.black3

@Composable
@Preview
fun BottomNavigationBar() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember {
        mutableStateOf(Screen.Home.route)
    }

    BottomAppBar(
        cutoutShape = CircleShape,
        contentColor = Color.White,
        backgroundColor = black3,
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEachIndexed { index, item ->
            if (index == 2) {
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = {},
                    enabled = false
                )
            }
            BottomNavigationItem(
                selected = (selectedItem == item.label),
                onClick = {
                    selectedItem = item.label
                    Toast.makeText(contextForToast, item.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        modifier = Modifier
                            .padding(top = 14.dp)
                    )
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }
    }
}

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> = listOf(
    BottomMenuItem(
        label = Screen.Home.route,
        icon = painterResource(R.drawable.btn_1)
    ),
    BottomMenuItem(
        label = Screen.Profile.route,
        icon = painterResource(R.drawable.btn_2)
    ),
    BottomMenuItem(
        label = Screen.Support.route,
        icon = painterResource(R.drawable.btn_3)
    ),
    BottomMenuItem(
        label = Screen.Settings.route,
        icon = painterResource(R.drawable.btn_4)
    ),

)

data class BottomMenuItem(
    val label: String,
    val icon: Painter,
)