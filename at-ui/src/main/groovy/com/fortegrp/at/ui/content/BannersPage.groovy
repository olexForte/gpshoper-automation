package com.fortegrp.at.ui.content

import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BannersPage extends BaseControlCenterPage{
    static at = {
        waitFor {
            header.displayed
            js.('document.readyState') == 'complete'
        }
    }

    static content = {
        header{$(By.xpath("//div[@class = 'headerToolbar']//span[text() = 'BANNERS']"))}
        addButton(wait:true){$('a', 'text':'ADD BANNER')}
    }

    def clickAddBannerButton()
    {
        addButton.click()
    }
}
