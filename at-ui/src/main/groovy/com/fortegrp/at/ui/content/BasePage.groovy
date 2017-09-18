package com.fortegrp.at.ui.content

import geb.Page

import static com.fortegrp.at.common.utils.LogHelper.logInfo

/**
 * Created by bray on 2/10/14.
 */

class BasePage extends Page {

    @Override
    void to(Map params, Object... args) {
        logInfo("Navigate to page " + getClass().simpleName)
        super.to(params, args)
    }

    @Override
    void onLoad(Page previousPage) {
        logInfo("Loading page " + browser.getCurrentUrl())
        super.onLoad(previousPage)
    }

    @Override
    boolean verifyAt() {
        logInfo("Verify at page " + getClass().simpleName)
        return super.verifyAt()
    }

    def getCurrentDateFormatted() {
        def date = new Date()
        date.format('MMMM d, yyyy')
    }

    def back() {
        driver.navigate().back()
    }

    protected void switchToLastWindow(timeout=5000) {
        Thread.sleep(timeout)
        driver.switchTo().window(driver.getWindowHandles()[driver.getWindowHandles().size() - 1])
    }
}
