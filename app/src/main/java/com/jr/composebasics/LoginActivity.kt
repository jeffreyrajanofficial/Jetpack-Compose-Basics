package com.jr.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.jr.composebasics.ui.theme.ComposeBasicsTheme
import androidx.compose.ui.tooling.preview.Preview

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    PreviewFormUI()
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewFormUI() {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        FormUI(
            username,
            password,
            onUsernameValueChange = {   name ->
                username = name
            },
            onPasswordValueChange = { pwd ->
                password = pwd
            },
            onLoginClicked = {
                username = ""
                password = ""
                Toast
                    .makeText(this, "Login Successful", Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }
}

@Composable
fun FormUI(
    username: String,
    password: String,
    onUsernameValueChange: (username: String) -> Unit,
    onPasswordValueChange: (password: String) -> Unit,
    onLoginClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement
            .spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = { onUsernameValueChange(it) },
            placeholder = {
                Text(text = stringResource(id = R.string.username))
            }
        )
        TextField(
            placeholder = {
                Text(text = stringResource(id = R.string.password))
                          },
            onValueChange = { onPasswordValueChange(it) },
            value = password,
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = onLoginClicked
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}
