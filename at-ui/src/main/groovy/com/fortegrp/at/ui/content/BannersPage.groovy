package com.fortegrp.at.ui.content

import org.openqa.selenium.By

/**
 * Page with banners list
 */
class BannersPage extends BaseControlCenterPage{
    static at = {
        waitFor {
            header.displayed
            !loaderSpinner.displayed
            js.('document.readyState') == 'complete'
        }
    }

    static content = {
        header{$(By.xpath("//div[@class = 'headerToolbar']//span[text() = 'BANNERS']"))}
        addButton(wait:true){$('a', 'text':'ADD BANNER')}
        bannerFromList{title -> ("//div[@class='bannerTable-second-row']//div[contains(text(),'" + title + "')]")}
        actionButtonByBannerTitle { title -> ("//div[@class='bannerTable-second-row']//div[contains(text(),'" + title + "')]/../..//button")  }
    }

    /**
     * Click on Add Banner button
     * @return
     */
    def clickAddBannerButton()
    {
        addButton.click()
    }

    /**
     * Click on Actions button and click on Edit link
     * @param title
     * @return
     */
    def editBannerByTitle(title){
        actionButtonByBannerTitle(title).click()
        $(By.xpath("//div[text()='EDIT']")).click()
    }
}
