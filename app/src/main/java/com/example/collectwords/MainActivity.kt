package com.example.collectwords

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collectwords.ui.theme.CollectWordsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollectWordsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column  (
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                    {
                        extracted(innerPadding) // your existing content


                        ColumnButton()

                    // now safely inside the Scaffold
                    }
                }
            }
        }
    }
}
@Composable
private fun extracted(innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(0.dp)) {
        Greeting(
            name = "rami",
            modifier = Modifier.padding(30.dp)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}







@Composable
fun ColumnButton() {
    var name by rememberSaveable { mutableStateOf("") }
    var output by rememberSaveable { mutableStateOf("") }
    val words = rememberSaveable { mutableStateListOf<String>()}
    Column {
        Row {
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text("Name") }
            )
        }
        Row {
            Button(onClick = { words.add(name) }) {
                Text("add")
            }
            Button(onClick = { words.clear()
                output = ""

            })
            {
                Text("Clear")
            }
            Button(onClick = { output = words.joinToString()}) {
                Text("Show")
            }

            Text(output.toString())

        }
    }
}



