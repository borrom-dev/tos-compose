package xyz.edsync.background

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBackground() {
    Column {
        Text(text = "Hello World", Modifier.background(Color.Red))
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = "Hello World", Modifier.aniBackground())
        Button(onClick = { /*TODO*/ }, Modifier.aniBackground()) {
            Text(text = "Click me")
        }

    }
}