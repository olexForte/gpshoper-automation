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
     * On Create banner page with no fields populated Click SAVE
     * Error message should be displayed
     */
    @TestDoc('AddBannerTest')
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

    //todo: finish the test
    def "Verify that user is able to save a new banner if all the required fields are populated."() {

        when: "Log in to the environment"
        openMainPage()

        and: "Proceed to Banners page"
        expandSideBarSection("MARKETING")
        selectSideBarMenuItem("Banner")
        at BannersPage

        and: "Click ADD BANNER"
        clickAddBannerButton()
        at BannerCreateEditPage

        and:"Select Platform"
        selectPlatformToggle(toggle)

        and: "Click SAVE"
        clickSaveButton()

        then:
        1==1

        where:
        toggle    | _
        'android' | _
        'ios'     | _
        'both'    | _
    }
}
