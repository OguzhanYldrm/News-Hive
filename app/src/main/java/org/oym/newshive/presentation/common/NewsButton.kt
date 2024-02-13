package org.oym.newshive.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.oym.newshive.ui.theme.NewsHiveTheme
import org.w3c.dom.Text

/**
 * Created by oguzhan.yildirim on 13.02.2024.
 */
@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick, 
        colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = SemiBold)
        )
    }
}

@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = SemiBold),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsTextButtonPreview() {
    NewsHiveTheme {
        NewsTextButton(text = "Back") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsButtonPreview() {
    NewsHiveTheme {
        NewsButton(text = "Next") {
            
        }
    }
}

