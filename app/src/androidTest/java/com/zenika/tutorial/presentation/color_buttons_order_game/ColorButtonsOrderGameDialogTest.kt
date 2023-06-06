package com.zenika.tutorial.presentation.color_buttons_order_game

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ColorButtonsOrderGameDialogTest {
    @get:Rule
    val rule = createComposeRule()

    private val stage = mutableStateOf(0)

    private fun onClick() {
        stage.value += 1
    }

    @Test
    fun clickOnBlueButton_incrementCount() {
        rule.setContent {
            ColorButtonsOrderGameDialog(
                size = stage.value,
                onDismissRequest = {},
                onColorClick = { onClick() })
        }

        //do something
        rule.onNodeWithText("@").performClick()

        //check something
        rule.onNodeWithText("1/4").assertExists()
    }

    @Test
    fun clickOnGreenButton_doNothing() {
        rule.setContent {
            ColorButtonsOrderGameDialog(
                size = stage.value,
                onDismissRequest = {},
                onColorClick = { onClick() })
        }

        //do something
        rule.onNodeWithText("#").performClick()

        //check something
        rule.onNodeWithText("0/4").assertExists()
    }

    @Test
    fun clickOnTwoFirstButtons_incrementCount() {
        rule.setContent {
            ColorButtonsOrderGameDialog(
                size = stage.value,
                onDismissRequest = {},
                onColorClick = { onClick() })
        }

        //do something
        rule.onNodeWithText("@").performClick()

        //check something
        rule.onNodeWithText("1/4").assertExists()

        //do something
        rule.onNodeWithText("#").performClick()

        //check something
        rule.onNodeWithText("2/4").assertExists()
    }

    @Test
    fun clickOnAllButtonsInOrder_incrementCount() {
        rule.setContent {
            ColorButtonsOrderGameDialog(
                size = stage.value,
                onDismissRequest = {},
                onColorClick = { onClick() })
        }

        //do something
        rule.onNodeWithText("@").performClick()

        //check something
        rule.onNodeWithText("1/4").assertExists()

        //do something
        rule.onNodeWithText("#").performClick()

        //check something
        rule.onNodeWithText("2/4").assertExists()

        //do something
        rule.onNodeWithText("%").performClick()

        //check something
        rule.onNodeWithText("3/4").assertExists()

        //do something
        rule.onNodeWithText("&").performClick()

        //check something
        rule.onNodeWithText("4/4").assertExists()
    }
}