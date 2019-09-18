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
class SettingsPrivacyRobot {
    // Privacy section
    fun verifyPrivacyHeading() = assertPrivacyHeading()
    fun verifyEnhancedTrackingProtectionButton() = assertEnhancedTrackingProtectionButton()
    fun verifyEnhancedTrackingProtectionValue() = assertEnhancedTrackingProtectionValue()
    fun verifyAddPrivateBrowsingShortcutButton() = assertAddPrivateBrowsingShortcutButton()
    fun verifySitePermissionsButton() = assertSitePermissionsButton()
    fun verifyDeleteBrowsingDataButton() = assertDeleteBrowsingDataButton()
    fun verifyDeleteBrowsingDataOnQuitButton() = assertDeleteBrowsingDataOnQuitButton()
    fun verifyDataCollectionButton() = assertDataCollectionButton()
    fun verifyPrivacyNoticeButton() = assertPrivacyNoticeButton()
    fun verifyLeakCanaryButton() = assertLeakCanaryButton()
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
    assertPrivacyHeading()
}

// Privacy section
private fun assertPrivacyHeading() {
    onView(ViewMatchers.withText("Privacy"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertEnhancedTrackingProtectionButton() = onView(ViewMatchers.withText("Enhanced Tracking Protection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertEnhancedTrackingProtectionValue() = onView(ViewMatchers.withText("On"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAddPrivateBrowsingShortcutButton() = onView(ViewMatchers.withText("Add private browsing shortcut"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSitePermissionsButton() {
    TestHelper.scrollToElementByText("Site permissions")
    onView(ViewMatchers.withText("Site permissions"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertDeleteBrowsingDataButton() = onView(ViewMatchers.withText("Delete browsing data"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDeleteBrowsingDataOnQuitButton() = onView(ViewMatchers.withText("Delete browsing data on quit"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDataCollectionButton() = onView(ViewMatchers.withText("Data collection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertPrivacyNoticeButton() = onView(ViewMatchers.withText("Privacy notice"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertLeakCanaryButton() = onView(ViewMatchers.withText("LeakCanary"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

private fun goBackButton() = onView(CoreMatchers.allOf(withContentDescription("Navigate up")))
