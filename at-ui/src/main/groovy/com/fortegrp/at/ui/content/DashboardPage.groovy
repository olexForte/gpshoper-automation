package com.fortegrp.at.ui.content

import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class DashboardPage extends BaseControlCenterPage{

    static at = {
        waitFor {
            header.displayed
            js.('document.readyState') == 'complete'
        }
    }

    static content = {
        header(wait: true) { $(By.xpath("//h1[contains(text(), 'DASHBOARD')]")) }
    }

}
