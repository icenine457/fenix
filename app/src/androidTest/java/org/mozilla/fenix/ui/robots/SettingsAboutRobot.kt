/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import org.hamcrest.CoreMatchers
import org.mozilla.fenix.helpers.TestHelper

/**
 * Implementation of Robot Pattern for the settings menu.
 */
class SettingsAboutRobot {
    // About section
    fun verifyAboutHeading() = assertAboutHeading()
    fun verifyHelp() = assertHelp()
    fun verifyRateOnGooglePlay() = assertRateOnGooglePlay()
    fun verifyAboutFirefoxPreview() = assertAboutFirefoxPreview()

    fun verifySettingsView() = assertSettingsView()
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
    assertAboutHeading()
}

// About section
private fun assertAboutHeading() {
    onView(ViewMatchers.withText("About"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertHelp() = onView(ViewMatchers.withText("Help"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertRateOnGooglePlay() {
    TestHelper.scrollToElementByText("Rate on Google Play")
    onView(ViewMatchers.withText("Rate on Google Play"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertAboutFirefoxPreview() = onView(ViewMatchers.withText("About Firefox Preview"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

private fun goBackButton() = onView(CoreMatchers.allOf(withContentDescription("Navigate up")))
