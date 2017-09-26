package com.fortegrp.at.ui.content

import com.fortegrp.at.ui.content.BasePage
import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BaseControlCenterPage extends BasePage{
    static at ={
        waitFor {
            navigationSideBar.displayed
            js.('document.readyState') == 'complete'
        }
    }
    static content = {
        loaderSpinner(required: false){$(By.xpath("//div[contains(@style,'transform: rotate(1800deg)')]"))}
        userDropDown{$(By.xpath("//div[contains(@class, 'header')]//a[@class='dropdown-toggle']"))}
        logoutOption{$(By.xpath("//div[contains(@class, 'header')]//a[text()='Logout']"))}
        navigationSideBar{$("ul.nav.nav-sidebar")}
        sideBarSection{sectionName -> navigationSideBar.$(By.xpath(".//a[text() = '"+ sectionName +"']"))}
        sideBarItem{itemName -> navigationSideBar.$(By.xpath(".//span[text() = '"+ itemName +"']"))}
    }

    /**
     * Wait for loading of page.<br>
     *     Wait until spinner appears and then wait until spinner disappear
     */
    def waitForPageLoadingBasedOnSpinner(){
       // waitFor{loaderSpinner.displayed}
       // waitFor{!loaderSpinner.displayed}
    }

    /**
     * Open Main menu item
     * @param sectionName section name (e.g. 'MARKETING')
     */
    def expandSideBarSection(sectionName){
        sideBarSection(sectionName).click()
    }

    /**
     * Open Submenu Item on Main menu
     * @param item item name (e.g. 'Banner')
     */
    def selectSideBarMenuItem(item){
        sideBarItem(item).click()
    }
}
