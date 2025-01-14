/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.ui

import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.mozilla.fenix.helpers.HomeActivityTestRule
import org.mozilla.fenix.ui.robots.homeScreen

/**
 *  Tests for verifying the search fragment
 *
 *  Including:
 * - Verify the toolbar, awesomebar, and shortcut bar are displayed
 * - Select shortcut button
 * - Select scan button
 *
 */

class SearchTest {
    /* ktlint-disable no-blank-line-before-rbrace */ // This imposes unreadable grouping.
    @get:Rule
    val activityTestRule = HomeActivityTestRule()

    @Test
    fun searchScreenItemsTest() {
        homeScreen {
        }.openSearch {
            verifySearchView()
            verifyBrowserToolbar()
            verifyScanButton()
            verifyShortcutsButton()
        }
    }

    @Ignore("This test cannot run on virtual devices due to camera permissions being required")
    @Test
    fun scanButtonTest() {
        homeScreen {
        }.openSearch {
            clickScanButton()
            clickDenyPermission()
            clickScanButton()
            clickAllowPermission()
        }
    }

    @Test
    fun shortcutButtonTest() {
        homeScreen {
        }.openSearch {
            verifySearchWithText()
            clickDuckDuckGoEngineButton()
            typeSearch("mozilla")
            verifyDuckDuckGoResults()
            clickDuckDuckGoResult()
            verifyDuckDuckGoURL()
        }
    }

    @Test
    @Ignore("Temp disable flakey test - see: https://github.com/mozilla-mobile/fenix/issues/5462")
    fun shortcutSearchEngineSettingsTest() {
        homeScreen {
        }.openSearch {
            scrollToSearchEngineSettings()
            clickSearchEngineSettings()
            verifySearchSettings()
        }
    }

    @Test
    fun clearSearchTest() {
        homeScreen {
        }.openSearch {
            typeSearch("test")
            clickClearButton()
            verifySearchBarEmpty()
        }
    }
}
