package xyz.edsync.business_banking.utils

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondary

@Composable
fun getDefaultTextFieldColors() =
    TextFieldDefaults.colors(
        focusedTextColor = ColorDarkPrimary,
        unfocusedTextColor = ColorDarkPrimary,
        cursorColor = ColorDarkPrimary,
        focusedIndicatorColor = ColorSecondary,
        unfocusedIndicatorColor = Color(0xFFD8D8D8),
        unfocusedLabelColor = Color(0xFF77869E),
        focusedLabelColor = Color(0xFF77869E),
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent
    )