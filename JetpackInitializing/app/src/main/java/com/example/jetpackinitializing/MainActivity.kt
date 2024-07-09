package com.example.jetpackinitializing

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackinitializing.ui.theme.JetpackInitializingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetpackInitializingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            Image(
                painter = painterResource(R.drawable.background_shade),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                        .padding(15.dp),
                    contentAlignment = Alignment.Center

                ) {
                    HomeTopAction()
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center,

                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f)
                                .clip(RoundedCornerShape(20.dp))
                        ){
                            Image(
                                painter = painterResource(R.drawable.home_card_bg),
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.fillMaxSize().background(color = Color(0xFF9988F7)),

                            )
                            HomeCard()
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(3f)
                                .background(Color.White)
                        ){
                            HomeFunction()
                        }

                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFF6F5FA))
        ){

        }
    }

}

@Composable
fun TransparentButtonWithImageAndText(onClick: () -> Unit, text: String, image: Painter) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x80FFFFFF) // Transparent white (50% opacity)
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color(0xFFE0E0E0)), // Dark white border
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Reward",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun ColorButtonWithImageAfterText(onClick: () -> Unit, text: String, image: Painter) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFE040)
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(50.dp,0.dp).fillMaxWidth().height(44.dp)
    ) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text(
                text = text,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(end = 8.dp)
            )
            Image(
                painter = image,
                contentDescription = null,
            )
        }
    }
}


@Composable
fun HomeTopAction(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Row (
            modifier = Modifier.fillMaxWidth().fillMaxHeight().weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.user_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "User Name!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "How are you today?",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp),
                contentAlignment = Alignment.Center

            ) {
                TransparentButtonWithImageAndText(
                    onClick = { /* Handle click */ },
                    text = "Rewards",
                    image = painterResource(id = R.drawable.reward_icon)
                )

            }
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bell_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun HomeCard(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp,0.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Account Balance", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "KHR 24,500.56", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center

        ){
            ColorButtonWithImageAfterText(
                onClick = { /* Handle click */ },
                text = "Request Fund",
                image = painterResource(id = R.drawable.next_black_arrow)
            )

        }
    }
}


@Composable
fun HomeFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        for (i in 0..1) { // Adjusted for 2 rows
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (j in 0..2) { // Adjusted for 3 columns
                    val buttonIndex = i * 3 + j + 1
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        HomeFunctionButton(
                            imageRes = R.drawable.user_icon, // Replace with your actual image resource
                            text = "Button $buttonIndex",
                            onClick = { onButtonClick(buttonIndex) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeFunctionButton(imageRes: Int, text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier.width(75.dp).height(75.dp))
            {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = text,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}

fun onButtonClick(buttonIndex: Int) {
    when (buttonIndex) {
        1 -> println("Button 1 clicked")
        2 -> println("Button 2 clicked")
        3 -> println("Button 3 clicked")
        4 -> println("Button 4 clicked")
        5 -> println("Button 5 clicked")
        6 -> println("Button 6 clicked")
        // Add more cases if needed
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackInitializingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Home(modifier = Modifier.padding(innerPadding))
        }
    }
}