package xyz.edsync.business_banking.utils

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import xyz.edsync.business_banking.ui.theme.ColorDarkPrimary
import xyz.edsync.business_banking.ui.theme.ColorSecondary

@Composable
fun getDefaultTextFieldColors() =
    TextFieldDefaults.textFieldColors(
        textColor = ColorDarkPrimary,
        cursorColor = ColorDarkPrimary,
        focusedIndicatorColor = ColorSecondary,
        unfocusedIndicatorColor = Color(0xFFD8D8D8),
        unfocusedLabelColor = Color(0xFF77869E),
        focusedLabelColor = Color(0xFF77869E)
    )