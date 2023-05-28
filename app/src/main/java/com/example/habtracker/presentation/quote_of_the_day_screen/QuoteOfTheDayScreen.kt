package com.example.habtracker.presentation.quote_of_the_day_screen.components

import android.content.res.Resources.Theme
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habtracker.presentation.quote_of_the_day_screen.GetQuoteOfTheDayViewModel
import com.example.habtracker.R

@Composable
fun QuoteOfTheDayScreen(
    navController: NavController,
    viewModel: GetQuoteOfTheDayViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Log.e("aaaaaa", "${state.quote}")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            state.quote?.let {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = it.title,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.notosans_regular))
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        modifier = Modifier.padding(top = 15.dp),
                        text = it.quote,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.secondary,
                        textAlign = TextAlign.Start,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily(Font(R.font.jost_italic))
                    )
                }

                Row(
                    modifier = Modifier.padding(top = 15.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it.author,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    )

                    Text(
                        text = it.date,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    )
                }
            }



        }

        FloatingActionButton(
            onClick = {navController.navigate("home")},
            modifier = Modifier.align(Alignment.BottomEnd),
            backgroundColor = MaterialTheme.colors.primary
        ) {

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Action Button"
            )

        }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colors.primary
            )
            Log.e("loading", "${state.isLoading}")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun QuoteScreenPreview() {
    QuoteOfTheDayScreen(navController = rememberNavController())
}