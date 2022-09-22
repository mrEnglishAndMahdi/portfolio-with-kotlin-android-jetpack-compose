package co.daneshyarwithmahdikhorshidi.testbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.daneshyarwithmahdikhorshidi.testbizcard.ui.theme.TestBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestBizCardTheme {
                    Main()
            }
        }
    }
}

@Composable
fun Main() {
    PortfolioBackground()
}

@Preview
@Composable
fun TestBizCardPreview() {
    Main()
}


@Composable
fun PortfolioBackground() {
    val exposed = remember {
        mutableStateOf(false)
    }
    val portfolioList = portfolioList()

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Card(
            modifier = Modifier.padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 10.dp,
            backgroundColor = Color.White,
            border = BorderStroke(0.1.dp, Color.Gray)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PortfolioPicture()
                PortfolioDivider()
                PortfolioInfo()
                Button(onClick = {
                    exposed.value = !exposed.value
                }
                ) {
                    Text(text = "Portfolio")
                }
                AnimatedVisibility(visible = exposed.value) {
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Color.White,
                        elevation = 10.dp,
                        border = BorderStroke(0.5.dp,Color.Cyan)
                    ) {
                        LazyColumn(verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally){
                            items(portfolioList){portfolio->
                               PortfolioItem(portfolio = portfolio)
                            }
                        }

                    }


                }


            }
        }
    }
}


@Composable
fun PortfolioDivider() {
    Divider(
        thickness = 1.dp, modifier = Modifier.padding(10.dp),
        color = Color.Gray
    )
}


@Composable
fun PortfolioPicture(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Filled.AccountBox,
        contentDescription = "AccountBox",
        tint = Color.Cyan,
        modifier = modifier.size(130.dp)
    )
}

@Composable
fun PortfolioInfo() {
    Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start) {
        Text(
            text = "Mahdi Khorshidi",
            color = Color.DarkGray,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Android Developer",
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Website Designer",
            color = Color.LightGray,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun PortfolioItem(portfolio:PortfolioList){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 10.dp,
        border = BorderStroke(0.5.dp,Color.Cyan)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            PortfolioPicture(modifier = Modifier.size(70.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
                ){
                Text(
                    text = portfolio.name,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = portfolio.familyName,
                    color = Color.Gray,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = portfolio.projectName,
                    color = Color.LightGray,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
            
        }
    }
}