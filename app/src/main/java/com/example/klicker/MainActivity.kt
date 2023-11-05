package com.example.klicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.klicker.ui.theme.KlickerTheme
import com.example.klicker.Colour

class MainActivity : ComponentActivity() {
    private val clr: Colour = Colour()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KlickerTheme {
                var n:Int by remember{
                    mutableStateOf(0)
                }
                var name: String by remember{
                    mutableStateOf("")
                }
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(clr.beige),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                        Greeting(name)

                        Text(text = "The Button has been clicked $n times",modifier = Modifier.padding(5.dp),)

                        OutlinedTextField(
                            value = name,
                            onValueChange = {   name = it   },
                            label = {   Text("Your name")  },
                            modifier = Modifier.padding(20.dp),

                        )

                        ElevatedButton(
                            onClick = { n++ },
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            shape = RoundedCornerShape(10.dp)

                        ) {
                            Text(text = "Click me!", fontWeight = FontWeight.Bold,)


                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name",
        modifier = modifier
    )
}