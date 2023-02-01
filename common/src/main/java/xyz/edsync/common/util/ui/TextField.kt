package xyz.edsync.common.util.ui

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.*

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelText: String,
    maxLines: Int = 1,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent
    ),
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        imeAction = ImeAction.Next
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    maxLength: Int? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    TextField(
        modifier = modifier,
        value = valueState.value,
        onValueChange = {
            val isValidMaxLength = maxLength != null && it.length <= maxLength
            if (isValidMaxLength || maxLength == null) {
                valueState.value = it
            }
        },
        label = { Text(text = labelText) },
        maxLines = maxLines,
        colors = colors,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        keyboardActions = keyboardActions,
    )
}

@Composable
fun TextInputPassword(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelText: String,
    imeAction: ImeAction = ImeAction.Done,
    maxLength: Int? = null,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent
    ),
) {
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    TextInputField(
        modifier = modifier,
        maxLength = maxLength,
        valueState = valueState,
        labelText = labelText,
        colors = colors,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image =
                if (passwordVisible.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible.value) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = image, description)
            }
        }
    )
}
