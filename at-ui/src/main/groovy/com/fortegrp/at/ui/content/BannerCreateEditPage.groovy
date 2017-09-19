package com.fortegrp.at.ui.content

import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BannerCreateEditPage extends BaseControlCenterPage{
    static content = {
        platformSelectors{$(By.xpath("//div[count(button) = 3]/button"))}
        bannerTitleField{$(By.xpath("//div[./span[text() = 'Banner Title']]/following-sibling::div/input"))}
        startDateSelect{$(By.xpath("//input[contains(@id, 'SelectStartDate')]"))}
        startTimeSelect{$(By.xpath("//input[contains(@id, 'SelectStartTime')]"))}
        endDateSelect{$(By.xpath("//input[contains(@id, 'SelectEndDate')]"))}
        endTimeSelect{$(By.xpath("//input[contains(@id, 'SelectEndTime')]"))}
        positionsDropDown{$(By.xpath("//div[text() = 'Positions']/following-sibling::div"))}
        actionSelect{$(By.xpath("//div[text() = 'Action Type and Value']/following-sibling::div"))}
        dropDownOption{text -> $(By.xpath("//span[@tabindex]//div[text() = '" + text +"']))}"))}
    }
}
