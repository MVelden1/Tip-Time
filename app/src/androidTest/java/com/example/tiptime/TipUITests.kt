package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    var composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percenttip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val excpectedTip = NumberFormat.getCurrencyInstance().format(2).replace("$", "€")
        composeTestRule.onNodeWithText("Tip Amount: $excpectedTip").assertExists(
            "No node with this text was fount."
        )

    }
}