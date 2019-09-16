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
import org.mozilla.fenix.R

/**
 * Implementation of Robot Pattern for the settings menu.
 */
class SettingsRobot {

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
    assertBasicsHeading()
    assertPrivacyHeading()
}


// Basics section
fun verifyBasicsHeading() = assertBasicsHeading()
fun verifySearchEngine() = assertSearchEngine()
fun verifyTheme() = assertTheme()
fun verifyAccessibility() = assertAccessibility()
fun verifyDefaultBrowser() = assertDefaultBrowser()

// Privacy section
fun verifyPrivacyHeading() = assertPrivacyHeading()
fun verifyTrackingProtection() = assertTrackingProtection()
fun verifySitePermissions() = assertSitePermissions()
fun verifyDeleteBrowsingData() = assertDeleteBrowsingData()
fun verifyDataCollection() = assertDataCollection()
fun verifyPrivacyNotice() = assertPrivacyNotice()
fun verifyLeakCanary() = assertLeakCanary()

// Developer tools section
fun verifyDeveloperToolsHeading() = assertDeveloperToolsHeading()
fun verifyRemoteDebug() = assertRemoteDebug()

// About section
fun verifyAboutHeading() = assertAboutHeading()
fun verifyHelp() = assertHelp()
fun verifyRateOnGooglePlay() = assertRateOnGooglePlay()
fun verifyAboutFirefoxPreview() = assertAboutFirefoxPreview()





// Basics section
private fun assertBasicsHeading() = onView(ViewMatchers.withText("Basics"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSearchEngine() = onView(ViewMatchers.withText("Search engine"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertTheme() = onView(ViewMatchers.withText("Theme"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAccessibility() = onView(ViewMatchers.withText("Accessibility"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDefaultBrowser() = onView(ViewMatchers.withText("Set as default browser"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// Privacy section
private fun assertPrivacyHeading() = onView(ViewMatchers.withText("Privacy"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertTrackingProtection() = onView(ViewMatchers.withText("Tracking Protection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSitePermissions() = onView(ViewMatchers.withText("Site permissions"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDeleteBrowsingData() = onView(ViewMatchers.withText("Delete browsing data"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDataCollection() = onView(ViewMatchers.withText("Data collection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertPrivacyNotice() = onView(ViewMatchers.withText("Privacy notice"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertLeakCanary() = onView(ViewMatchers.withText("LeakCanary"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// Developer tools section
private fun assertDeveloperToolsHeading() = onView(ViewMatchers.withText("Developer tools"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertRemoteDebug() = onView(ViewMatchers.withText("Remote debugging via USB"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// About section
private fun assertAboutHeading() = onView(ViewMatchers.withText("About"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertHelp() = onView(ViewMatchers.withText("Help"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertRateOnGooglePlay() = onView(ViewMatchers.withText("Rate on Google Play"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAboutFirefoxPreview() = onView(ViewMatchers.withText("About Firefox Preview"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))



private fun goBackButton() = onView(CoreMatchers.allOf(withContentDescription("Navigate up")))

fun swipeToBottom() = onView(ViewMatchers.withId(R.id.recycler_view)).perform(ViewActions.swipeUp())
