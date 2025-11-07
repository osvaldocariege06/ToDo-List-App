package com.example.todolistapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    var taskList by remember { mutableStateOf(listOf<String>()) }
    var newTask by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Text(
            text = "Minhas tarefas",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = newTask,
            onValueChange = {
                newTask = it
                if(isError){
                    isError = false
                }
            },
            label = { Text("Digite sua nova tarefa:") },
            supportingText = {
                if(isError){
                    Text(
                        text = "A tarefa não pode estar vazia.",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }


        )
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            if (newTask.isNotBlank()){
                taskList += newTask
                newTask = ""
            } else {
                isError = true
            }

        },
            modifier = Modifier.align(Alignment.End)) {
            Text(
                text = "Adicionar tarefa"
            )
        }

        Spacer(Modifier.height((8.dp)))

        LazyColumn() {
            items(taskList) { task ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = task,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(16.dp)
                        )

                        Button(
                            onClick = {}
                        ) {
                            Text(
                                text = "Deletar", modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home(navController = rememberNavController())
}
