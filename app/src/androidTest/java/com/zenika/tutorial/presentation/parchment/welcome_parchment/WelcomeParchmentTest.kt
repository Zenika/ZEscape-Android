package com.zenika.tutorial.presentation.parchment.welcome_parchment

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import org.junit.Rule
import org.junit.Test

class WelcomeParchmentTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun clickOnFirstArrow_slideToNextPage() {
        composeRule.setContent {
            WelcomeParchmentScreen(
                openInstruction = {}
            )
        }

        //check first page content
        composeRule.onNodeWithText(text = "Cher voyageur", substring = true).assertExists()

        val firstArrowDescription = "Flèche qui permet de passer à la page 1"

        //click on arrow image
        composeRule.onNodeWithContentDescription(firstArrowDescription)
            .performClick()

        //check second page content
        composeRule.onNodeWithText(text = "Il y a fort longtemps", substring = true).assertExists()
    }

    @Test
    fun clickOnAllArrows_slideToLastPage() {
        composeRule.setContent {
            WelcomeParchmentScreen(
                openInstruction = {}
            )
        }

        //check first page content
        composeRule.onNodeWithText(text = "Cher voyageur", substring = true).assertExists()

        val firstArrowDescription = "Flèche qui permet de passer à la page 1"
        val secondArrowDescription = "Flèche qui permet de passer à la page 2"

        //click on arrows
        composeRule.onNodeWithContentDescription(firstArrowDescription).performClick()
        composeRule.onNodeWithContentDescription(secondArrowDescription).performClick()

        //check last page content
        composeRule.onNodeWithText(text = "Capitaine J. Zparrow", substring = true).assertExists()
    }

    @Test
    fun swipeToNextPage_slideToNextPage() {
        composeRule.setContent {
            WelcomeParchmentScreen(
                openInstruction = {}
            )
        }

        //check first page content
        composeRule.onNodeWithText(text = "Cher voyageur", substring = true).assertExists()

        //swipe to the left
        composeRule.onNodeWithText("Cher voyageur", substring = true).performTouchInput {
            this.swipeLeft(
                startX = this.centerX,
                endX = this.left,
                durationMillis = 200
            )
        }

        //check second page content
        composeRule.onNodeWithText(text = "Il y a fort longtemps", substring = true).assertExists()
    }
}