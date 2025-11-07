package com.example.todolistapp.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CreateTask(navController: NavController) {
    Text(text = "Create Task")
}



@Preview
@Composable
fun CreateTaskPreview(){
    CreateTask(navController = rememberNavController())
}