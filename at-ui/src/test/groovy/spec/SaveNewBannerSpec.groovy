package spec

import com.fortegrp.at.common.annotation.TestDoc
import com.fortegrp.at.ui.BaseUISpec
import com.fortegrp.at.ui.content.BannerCreateEditPage
import com.fortegrp.at.ui.content.BannersPage
import com.fortegrp.at.ui.content.BaseControlCenterPage
import org.apache.commons.io.filefilter.FalseFileFilter

/**
 * Created by Admin on 9/20/2017.
 */
class SaveNewBannerSpec extends BaseUISpec{

    /**
     * Verify that user is not able to save a new banner without filling the required fields:
     * Log in to the environment
     * Proceed to Banners page
     * Click ADD BANNER
     * On Create banner page Click SAVE
     */
    @TestDoc('LoginTest')
    def "Verify that user is not able to save a new banner without filling the required fields."() {

        when: "Log in to the environment"
        openMainPage()

        and: "Proceed to Banners page"
        expandSideBarSection("MARKETING")
        selectSideBarMenuItem("Banner")
        at BannersPage

        and: "Click ADD BANNER"
        clickAddBannerButton()
        at BannerCreateEditPage

        and: "Click SAVE"
        clickSaveButton()

        then: "Error message should be displayed"
        // todo: environment hangs, endless spiner
        false
    }
}
