package xyz.edsync.shape

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SampleShapeScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {}, shape = RectangleShape) {
            Text("None")
        }

        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50)) {
            Text(text = "OK")
        }

        Button(onClick = { /*TODO*/ }, shape = shapes.medium) {
            Text(text = "Small")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SampleShapePreview() {
    SampleShapeScreen()
}