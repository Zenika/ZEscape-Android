package com.zenika.tutorial.presentation.parchment.welcome_parchment

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WelcomeParchmentTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun clickFirstArrow_slideToNextPage() {
        composeRule.setContent {
            WelcomeParchmentScreen(
                openInstruction = {}
            )
        }

        //do something
        composeRule.onNodeWithContentDescription("Flèche qui permet de passer à la page suivante")
            .performClick()

        //check something
        composeRule.onNodeWithText(
            "Il y a fort longtemps, j'ai perdu un trésor contenant une " +
                    "mystérieuse carte, et je souhaite la retrouver."
        )
            .assertExists()
    }
}