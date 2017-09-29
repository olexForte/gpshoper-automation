package com.fortegrp.at.ui

import com.fortegrp.at.common.BaseSpec
import com.fortegrp.at.common.env.Environment
import com.fortegrp.at.ui.content.BaseControlCenterPage
import com.fortegrp.at.ui.content.DashboardPage
import com.fortegrp.at.ui.content.LoginPage
import com.fortegrp.at.ui.utils.TestProperties
import geb.spock.GebReportingSpec
import org.openqa.selenium.Dimension
import org.openqa.selenium.Keys

import java.awt.*

import static com.fortegrp.at.common.utils.LogHelper.logInfo

/**
 * Created by Leo on 2/24/2017.
 */
class BaseUISpec extends GebReportingSpec implements BaseSpec {

    /**
     * Opens browser, navigates to the base url(Base url is set in a GebConfig.groovy)
     */
    def startApplication() {
        logInfo("Browser window opening...")
        browser.go(baseUrl)
    }

    /**
     * Navigates to the login page. Logs in with credentials provided in VM parameters (e.g. -Dusername=username -Dpassword=password)
     */
    def openMainPage() {
        at LoginPage
        loginAs(System.getProperty('username'), System.getProperty('password'))
        at DashboardPage
    }

    //todo: Why the methods below are in the BaseUISpec? Why do all the specs need to inherit this methods? It seems unnecessary.
    void cleanReportGroupDir() {
    }

    def getScreenWidth() {
        def toolkit = Toolkit.getDefaultToolkit()
        def dim = toolkit.getScreenSize()
        dim.width
    }

    def maximizeWindow() {
        driver.manage().window().maximize()
    }

    def resizeWindow(width, height) {
        driver.manage().window().setSize(new Dimension(width, height))
    }

    def sendControlCKeysToElement(element) {
        if (Environment.browserType.equals("safari")) {
            element << Keys.chord(Keys.COMMAND + "c")
        } else {
            element << Keys.chord(Keys.CONTROL + "c")
        }
    }

    def sendControlVKeysToElement(element) {
        if (Environment.browserType.equals("safari")) {
            element << Keys.chord(Keys.COMMAND + "v")
        } else {
            element << Keys.chord(Keys.CONTROL + "v")
        }
    }

    def backSpace(numTimes, ourTextObject) {
        for (int i in 0..numTimes) {
            ourTextObject << Keys.chord(Keys.BACK_SPACE)
        }
    }
}
