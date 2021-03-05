package com.jr.composebasics

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jr.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Scaffold {
                    EntryScreen()
                }
            }
        }
    }

    @Preview
    @Composable
    fun EntryScreen() {
        OnBoardingPage {
            if (it == ButtonType.FORM) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                startActivity(Intent(this, ListActivity::class.java))
            }
        }
    }
}


@Composable
fun OnBoardingPage(onClick: (ButtonType) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = { onClick(ButtonType.FORM) },
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = "Open Form Page")
        }

        Button(onClick = { onClick(ButtonType.LIST) }) {
            Text(text = "Open List Page")
        }
    }
}

enum class ButtonType {
    FORM,
    LIST
}