package com.example.watch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.watch.presentation.theme.WatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    WatchTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            OmnitrixDesign()
        }
    }
}

@Composable
fun OmnitrixDesign() {
    // Omnitrix Design
    Box(
        modifier = Modifier
            .size(200.dp) // Size of the Omnitrix
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {




        // Green Centerpiece
        Canvas(modifier = Modifier.size(100.dp)) {
            drawCircle(
                color = Color.Green,
                radius = size.minDimension / 2+29
            )
        }

        // Iconic "X" in the center
        Triangle()
        Triangle2()

        // Inner Ring
        Canvas(modifier = Modifier.size(160.dp)) {
            drawCircle(
                color = Color.Gray,
                radius = size.minDimension / 2,
                style = Stroke(width = 6.dp.toPx())
            )
        }

        //outer ring
        Canvas(modifier = Modifier.size(200.dp)) {
            drawCircle(
                color = Color.DarkGray,
                radius = size.minDimension / 2,
                style = Stroke(width = 8.dp.toPx())
            )
        }


        // Placeholder buttons (Top, Bottom, Left, Right)

    }
}

@Composable
fun Triangle() {
    Canvas(modifier = Modifier.size(200.dp)) {
        // Define the triangle path
        val path = Path().apply {
            moveTo(260f, size.height / 2) // Left-center of the canvas
            lineTo(size.width, 0f)     // Top-right corner
            lineTo(size.width, size.height) // Bottom-right corner
            close() // Closes the path to form a triangle
        }

        // Draw the triangle
        drawPath(
            path = path,
            color = Color.Black
        )
    }
}
@Composable
fun Triangle2() {
    Canvas(modifier = Modifier.size(200.dp)) {
        // Define the triangle path
        val path = Path().apply {
            moveTo(162f, size.height / 2) // Right-center of the canvas
            lineTo(0f, 0f)                     // Top-left corner
            lineTo(0f, size.height)
            close() // Closes the path to form a triangle
        }

        // Draw the triangle
        drawPath(
            path = path,
            color = Color.Black
        )
    }
}


@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun OmnitrixPreview() {
    WearApp()
}
