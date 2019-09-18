/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import org.hamcrest.CoreMatchers

/**
 * Implementation of Robot Pattern for the settings menu.
 */
class SettingsBasicsRobot {
    // Basics section
    fun verifyBasicsHeading() = assertBasicsHeading()
    fun verifySearchEngineButton() = assertSearchEngineButton()
    fun verifySearchEngineSelected() = assertSearchEngineSelected()
    fun verifyThemeButton() = assertThemeButton()
    fun verifyThemeSelected() = assertThemeSelected()
    fun verifyAccessibilityButton() = assertAccessibilityButton()
    fun verifySetAsDefaultBrowserButton() = assertSetAsDefaultBrowserButton()

    class Transition {

        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: HomeScreenRobot.() -> Unit): HomeScreenRobot.Transition {

            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            HomeScreenRobot().interact()
            return HomeScreenRobot.Transition()
        }
    }
}

private fun assertSettingsView() {
    // verify that we are in the correct library view
    assertBasicsHeading()
}

// Basics section
private fun assertBasicsHeading() = onView(ViewMatchers.withText("Basics"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSearchEngineButton() {
    onView(ViewMatchers.withText("Search engine"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertSearchEngineSelected() {
    onView(ViewMatchers.withText("Google"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertThemeButton() = onView(ViewMatchers.withText("Theme"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertThemeSelected() = onView(ViewMatchers.withText("Light"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAccessibilityButton() = onView(ViewMatchers.withText("Accessibility"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSetAsDefaultBrowserButton() = onView(ViewMatchers.withText("Set as default browser"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

private fun goBackButton() = onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
