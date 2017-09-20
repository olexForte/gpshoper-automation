package com.fortegrp.at.ui.content

import com.fortegrp.at.ui.content.BasePage
import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BaseControlCenterPage extends BasePage{
    static content = {
        userDropDown{$(By.xpath("//div[contains(@class, 'header')]//a[@class='dropdown-toggle']"))}
        logoutOption{$(By.xpath("//div[contains(@class, 'header')]//a[text()='Logout']"))}
        navigationSideBar{$("ul.nav.nav-sidebar")}
        sideBarSection{sectionName -> navigationSideBar.$(By.xpath(".//a[text() = '"+ sectionName +"']"))}
        sideBarItem{itemName -> navigationSideBar.$(By.xpath(".//span[text() = '"+ itemName +"']"))}
    }

    /**
     * Open Main menu item
     * @param menuItem
     */
    def navigateToMainMenuItem(menuItem){
        sideBarSection(menuItem).click()
    }

    /**
     * Open Submenu Item on Main menu
     * @param item
     */
    def navigateToSubMenuItem(item){
        sideBarItem(item).click()
    }
}
