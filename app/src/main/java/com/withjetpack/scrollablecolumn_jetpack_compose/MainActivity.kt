package com.withjetpack.scrollablecolumn_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withjetpack.scrollablecolumn_jetpack_compose.ui.theme.ScrollableColumnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumnJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScrollableColumnComponent()
                }
            }
        }
    }
}

@Composable
fun ScrollableColumnComponent() {
    var listData = listOf("India", "US", "UK", "Iran")
   Column(modifier = Modifier.fillMaxSize()) {
       Text("ScrollableColumnComponent", color = Color.Red, modifier = Modifier.padding(20.dp), fontSize = 20.sp)
       LazyColumn(
           modifier = Modifier
               .fillMaxSize()
               .padding(20.dp)
       ) {
           items(listData) { index ->

               Box(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(5.dp)
                       .background(if (index.startsWith("I")) Color.Gray else Color.LightGray)
               ){
                   Text("$index", modifier = Modifier.padding(16.dp))
               }
           }
       }
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollableColumnJetpackComposeTheme {
        ScrollableColumnComponent()
    }
}