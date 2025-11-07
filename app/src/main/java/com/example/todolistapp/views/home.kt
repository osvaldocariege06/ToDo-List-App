package com.example.todolistapp.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavController) {
    Text(text = "Home Screen")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePreview(){
    Home(navController = rememberNavController())
}