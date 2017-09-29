package spec

import com.fortegrp.at.common.annotation.TestDoc
import com.fortegrp.at.ui.BaseUISpec
import com.fortegrp.at.ui.content.BannerCreateEditPage
import com.fortegrp.at.ui.content.BannersPage
import com.fortegrp.at.ui.entities.BannerEntity
import com.fortegrp.at.ui.utils.TestProperties

/**
 * EditBannerSpec

 1	Click on edit button for any banner.
 2	Click on update after each steps 3-11
 3	Verify that user is able to toggle between platform indicator and update.
 4	Verify that user is able to change/edit banner title.
 5	Verify that user is able to change position.
 6	Verify that user is able to change action type and value.
 7	Verify that user is able to update old image with the new one.
 8	Verify that user is able to change start/end date/time.
 9	Verify that user is able to change recipient radio button.
 10	Verify that user is able to change the selected segment by check/uncheck the checkbox.
 11	Change two or more field at one time and check the changes on banner list page.

 */

class EditBannerSpec extends BaseUISpec{

    def static file1 = "EditBannerTestData1.json"
    def static file2 = "EditBannerTestData2.json"

    /**

     */

    @TestDoc('Edit banner')
    def "Verify that user is able to edit Banner fields"() {

        when: ""
        BannerEntity banner1 = new BannerEntity.BannerEntityBuilder(TestProperties.readTestDataFromJSON(file1)).build()
        BannerEntity banner2 = new BannerEntity.BannerEntityBuilder(TestProperties.readTestDataFromJSON(file2)).build()

        and: "Log in to the environment"
        openMainPage()

        and: "Proceed to Banners page"
        expandSideBarSection("MARKETING")
        selectSideBarMenuItem("Banner")
        at BannersPage

        and: "Open banner"
        editBannerByPartOfTitle(title)

        at BannerCreateEditPage

        and: "Position select"
        positionsDropDown(position)

        and: "Click on Upload button"
        clickOnUploadButton()

        and: "Click on Uploaded Image"
        clickOnUseExistingImageButton()

        and: "Set file to upload"
        selectExistingImageGroup(groupOfImages)
        selectExistingImage(existingImageLocator)

        then: "Check file was uploaded"
        String actualLocator = getCurrentBannerImageSrcLocator()
        assert actualLocator.equals(existingImageLocator) : "Actual locator (" + actualLocator + ") does not equal to expected '" + existingImageLocator + "'"


        where:
        title = TestProperties.readTestDataFromJSON(path).title

    }

}
