package com.jr.composebasics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jr.composebasics.ui.theme.ComposeBasicsTheme

class ListActivity : AppCompatActivity() {
    private val contactList  = listOf(
                Contact("Jeffrey Rajan", "+918808808800"),
                Contact("Dinesh Natarajann", "+916793808800"),
                Contact("Badhan Ganesh", "+919955408800"),
                Contact("Akhil Joy", "+919988808800"),
                Contact("Bryan Buford", "+918808807310"),
                Contact("Dukhi Ram", "+918808808799"),
                Contact("Jean Paul", "+918808807700"),
                Contact("Jobin Geaorge", "+918807618800"),
                Contact("Joan Dally", "+918808899000"),
                Contact("James Robinson", "+918803258800"),
                Contact("Hari Haran", "+918808812300"),
                Contact("Sugumar Sambath", "+918805668800"),
                Contact("Kevin Anderson", "+918808228800"),
                Contact("Mounika Velma", "+918807618800"),
                Contact("Sai Charan", "+918808147800"),
                Contact("Thomas Ramesh", "+918811908800")
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    color = MaterialTheme.colors.background) {
                    PreviewList()
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewList() {
        VerticalLazyView(contactList)
    }
}

data class Contact(
    val name: String,
    val number: String
)

@Preview
@Composable
fun PreviewContactInfoCard() {
    ContactInfoCard(contact = Contact("Jeffrey Rajan", "+918807300099"))
}

@Composable
fun ContactInfoCard(contact: Contact) {
    contact.apply {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green)
                    .padding(15.dp),
                Alignment.Center
            ) {
                Text(text = getFirstChar(name))
            }

            Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = name)
                    Text(text = number)
            }
        }
    }
}

fun getFirstChar(name: String): String {
    val fullName = name.split(" ")
    return fullName[0].first().toString() + fullName[1].first()
}

@Composable
fun VerticalLazyView(contactList: List<Contact>) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        items(contactList) { item ->
            ContactInfoCard(contact = item)
        }
    }
}
