package com.zenika.tutorial.presentation.color_buttons_order_game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ColorButtonsOrderGameDialogTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun clickOnButton_incrementCount() {
        rule.setContent {
            var stage by remember {
                mutableStateOf(0)
            }

            ColorButtonsOrderGameDialog(
                size = stage,
                onDismissRequest = {},
                onColorClick = { stage += 1 })
        }

        //check something
        rule.onNodeWithText("0/4").assertExists()

        //do something
        rule.onNodeWithText("@").performClick()

        //check something
        rule.onNodeWithText("1/4").assertExists()
    }

    @Test
    fun displayGoodStage() {
        rule.setContent {
            ColorButtonsOrderGameDialog(
                size = 3,
                onDismissRequest = {},
                onColorClick = {})
        }

        //check something
        rule.onNodeWithText("3/4").assertExists()
    }
}