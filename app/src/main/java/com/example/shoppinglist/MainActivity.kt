package com.example.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val shoppingItems = listOf("Apples","Bananas","Milk","Bread","Eggs", "Coffee")
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        // Main Header
        Text (text = "Welcome to Group 6 Shopping App")
        Spacer( modifier = Modifier.height(16.dp))
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(shoppingItems) { item ->
            Card(
                modifier = modifier.fillMaxSize(), shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = item,
                    modifier = modifier.padding(16.dp)
                )
            }
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ShoppingListTheme {
        MainScreen()
    }
}