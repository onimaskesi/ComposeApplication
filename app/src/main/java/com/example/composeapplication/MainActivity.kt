package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.ui.theme.Shapes
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .padding(start = 15.dp),
                verticalArrangement = Arrangement.SpaceAround,
                //horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for(i in 1..7){
                    Row(
                        //modifier = Modifier.fillMaxWidth(),
                        //horizontalArrangement = Arrangement.SpaceAround
                        ){

                        val size = 10*i

                        Text(
                            text = "I",
                            fontSize = size.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.padding(end = size.dp)
                        )

                        Heart(size)

                        Text(
                            text = "U",
                            fontSize = size.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.padding(start = size.dp)
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Heart(size : Int) {

    Surface(
        color = Color.Black.copy(alpha = 0f),
        modifier = Modifier
            .size(width = size.dp, height = size.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.5f)
                        .offset(x = (size / 25).dp)
                        .background(shape = CircleShape, color = Color.Red)
                        //.border(width = 2.dp, SolidColor(Color.Black), shape = CircleShape)

                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(1f)
                        .offset(x = (-2).dp)
                        //.border(width = 2.dp, color = Color.Red, shape = CircleShape)
                        .background(shape = CircleShape, color = Color.Red)
                )

            }

            Box(modifier = Modifier
                .rotate(45f)
                .offset(x = (-size / (4.8)).dp, y = (-size / (4.8)).dp)
                .size(width = (size / 2).dp, height = (size / 2).dp)
                //.border(width = 2.dp, color = Color.Red)
                .background(color = Color.Red)
                )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Heart(50)
}