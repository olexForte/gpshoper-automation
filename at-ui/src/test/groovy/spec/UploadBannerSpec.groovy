package spec

import com.fortegrp.at.common.annotation.TestDoc
import com.fortegrp.at.ui.BaseUISpec
import com.fortegrp.at.ui.content.BannerCreateEditPage
import com.fortegrp.at.ui.content.BannersPage

/**
 * Created by Admin on 9/20/2017.
 */
class UploadBannerSpec extends BaseUISpec{

    /**
     1	Select any position from dropdown menu.
     2	Move your cursor to required size tool tip.
     3	Click on upload banner icon.
     4	Click on upload banner text
     5	Select image upload option.
     6	Click on Scheduled
     7	Click on Expired
     8	Click on Live
     9	Click on Cancel button.
     10	Move cursor on Live/Schedule/Expired upload image page.
     11	Click on use button
     12	Select new image option for banner upload
     13	Click on Cancel button.
     14	Verify that user can drop image on the light box.
     15	Verify that clicking on the dropzone shows popup to choose file.
     16	Move cursor on required size tool tip.
     17	Verify that after uploading the image banner details button gets displayed.
     18	Click on banner details button
     19	Verify that if actual banner size exceeds the expected banner size, error message gets displayed.
     20	Verify that if all required fields are not done correctly user is not able to upload an image.
     */
    @TestDoc('UploadBannerTest')
    def "Verify that user is able to upload"() {

        when: "Log in to the environment"
        openMainPage()

        and: "Proceed to Banners page"
        expandSideBarSection("MARKETING")
        selectSideBarMenuItem("Banner")
        at BannersPage

        and: "Click ADD BANNER"
        clickAddBannerButton()

        at BannerCreateEditPage

        and: "Position select"
        positionsDropDown("home top 2")

        and: "Click on Upload button"

        clickOnUploadButton()

        clickOnNewImageButton()

        uploadFileFromDialog()

        then: ""
        // todo: environment hangs, endless spiner
        false
    }
}
