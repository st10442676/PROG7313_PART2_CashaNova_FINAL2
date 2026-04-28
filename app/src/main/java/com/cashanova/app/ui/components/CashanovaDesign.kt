package com.cashanova.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cashanova.app.ui.theme.Black
import com.cashanova.app.ui.theme.BlackSurface
import com.cashanova.app.ui.theme.Gold
import com.cashanova.app.ui.theme.GoldButton
import com.cashanova.app.ui.theme.TextGray
import com.cashanova.app.ui.theme.TextWhite

@Composable
fun CashanovaBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Black, BlackSurface, Black)
                )
            )
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
fun GoldButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GoldButton,
            contentColor = Black
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun GoldTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier,
        singleLine = true,
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gold,
            unfocusedBorderColor = TextGray,
            focusedLabelColor = Gold,
            unfocusedLabelColor = TextGray,
            focusedTextColor = TextWhite,
            unfocusedTextColor = TextWhite
        )
    )
}

