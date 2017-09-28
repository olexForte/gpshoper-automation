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
    def "Verify that user is able to upload new file"() {

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
        positionsDropDown(position)

        and: "Click on Upload button"
        clickOnUploadButton()

        and: "Click on New Image"
        clickOnNewImageButton()

        and: "Set file to upload"
        uploadFileFromDialog(filename)

        then: "Check file was uploaded"
        assert checkImageWasSpecified()

        where:
        position = "home top 2"
        filename = "live_banner.jpeg"

    }

    /**
     1	Select any position from dropdown menu.
     2	Move your cursor to required size tool tip.
     3	Click on upload banner icon.
     4	Click on upload banner text
     5	Select image upload option.
     6	Click on Scheduled
     10	Move cursor on Live/Schedule/Expired upload image page.
     11	Click on use button
     */

    @TestDoc('SelectExistingBannerTest')
    def "Verify that user is able to select existing images"() {

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
        position = "home top 2"
        groupOfImages = "EXPIRED" //"""LIVE"
        existingImageLocator = "52e84bead4b20bf3047895b36f877339fdd3d217d110e1d1ba951116d0ac1200"
                //"f77e0e9c3fac4b879346f9c0443c71600f8436156a021ee55c3f14e41a7568a0"

    }


    /**
     1	Select any position from dropdown menu.
     2	Move your cursor to required size tool tip.
     */
    @TestDoc('UploadBannerTest Tooltip verification')
    def "Verify that user is able to see Required Size tooltip"() {

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
        positionsDropDown(position)

        then: "Check tooltip works"
        String actualTooltipText = getRequiredSizeTooltipText();
        assert actualTooltipText.replaceAll("\\W","").equals(expectedText.replaceAll("\\W","")) :
                "Actual tooltip text (" + actualTooltipText + ") does not equal to expected (" + expectedText +")"

        where:
        expectedText = "Image Size in Server\n" +
                "File Format: jpg and png\n" +
                "Expected Banner Size: 1440X750\n" +
                "Expected File Size: 1000 KB"
        position = "home top 2"

    }

    /**
     1	Select any position from dropdown menu.
     3	Click on upload banner icon.
     4	Click on upload banner text
     5	Select image upload option.
     8	Click on Live
     11	Click on use button
     12	Select new image option for banner upload
     13	Click on Cancel button.
     14	Verify that user can drop image on the light box.
     15	Verify that clicking on the dropzone shows popup to choose file.
     16	Move cursor on required size tool tip.
     17	Verify that after uploading the image banner details button gets displayed.
     18	Click on banner details button
     */
    @TestDoc('UploadBannerTest Banner Details button validation')
    def "Verify that user is able to see Banner Details tooltip"() {

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
        positionsDropDown(position)

        and: "Click on Upload button"
        clickOnUploadButton()

        and: "Click on Uploaded Image"
        clickOnUseExistingImageButton()

        and: "Set file to upload"
        selectExistingImage(existingImageLocator)

        then: "Check Banner Details button shows expected tooltip"
        String actualTooltipText = getBannerDetailsTooltipText();
        assert actualTooltipText.replaceAll("\\W","").equals(expectedText.replaceAll("\\W","")) :
                "Actual tooltip text (" + actualTooltipText + ") does not equal to expected (" + expectedText +")"

        where:
        expectedText = "Image Size in Server\n" +
                "File Format: jpg and png\n" +
                "Expected Banner Size: 1440X750\n" +
                "Expected File Size: 1000 KB\n" +
                "Actual Banner Size: 300X150"
        position = "home top 2"
        existingImageLocator = "2d1d94e130affd41452607b1d1351f46685fdd5fb3947ff1b29b87a365d4651c"
        //"f77e0e9c3fac4b879346f9c0443c71600f8436156a021ee55c3f14e41a7568a0"
    }

    /**
     1	Select any position from dropdown menu.
     3	Click on upload banner icon.
     5	Select image upload option.
     6	Click on Live
     20	Verify that if all required fields are not done correctly user is not able to upload an image.
     */

    @TestDoc('UploadBannerTest fields validation')
    def "Verify that user can not save Banner without required fields"() {

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
        positionsDropDown(position)

        and: "Try to save without required fields"
        clickSaveButton()

        then: "Error message validation"
        String actualMessageText = getErrorMessageFromSubmissionErrorsDialog();
        assert actualMessageText.replaceAll("\\W","").equals(expectedText.replaceAll("\\W","")) :
                "Actual error text (" + actualMessageText + ") does not equal to expected (" + expectedText +")"


        where:
        expectedText = "* action type missing\n" +
                "* action value missing\n" +
                "* title missing\n" +
                "* image missing"
        position = "home top 2"
    }

    /**
     1	Select any position from dropdown menu.
     3	Click on upload banner icon.
     5	Select image upload option.
     6	Click on Live
     19	Verify that if actual banner size exceeds the expected banner size, error message gets displayed.
     */

    @TestDoc('UploadBannerTest image size validation')
    def "Verify that user can not save Banner with image that exceeds expected banner Height"() {

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
        positionsDropDown(position)

        and: "Click on Upload button"
        clickOnUploadButton()

        and: "Click on New Image"
        clickOnNewImageButton()

        and: "Set file to upload (file has Height > 750)"
        uploadFileFromDialog(filenameHeight)

        then: "Check file was not uploaded"
        assert !checkImageWasSpecified()

        and : "Error message validation"
        String actualMessageText = getErrorMessageFromImageErrorUploadDialog();
        assert actualMessageText.replaceAll("\\W","").equals(expectedTextHeight.replaceAll("\\W","")) :
                "Actual error text (" + actualMessageText + ") does not equal to expected (" + expectedTextHeight +")"

        where:
        filenameHeight = "height_exceed_banner.jpeg"
        expectedTextHeight = "The expected banner size is 1440x750 - the banner you uploaded exceeds the Height!"
        position = "home top 2"
    }

    /**
     1	Select any position from dropdown menu.
     3	Click on upload banner icon.
     5	Select image upload option.
     6	Click on Live
     19	Verify that if actual banner size exceeds the expected banner size, error message gets displayed.
     */

    @TestDoc('UploadBannerTest image size validation')
    def "Verify that user can not save Banner with image that exceeds expected banner Width"() {

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
        positionsDropDown(position)

        and: "Click on Upload button"
        clickOnUploadButton()

        and: "Click on New Image"
        clickOnNewImageButton()

        and: "Set file to upload (file has Width > 1440)"
        uploadFileFromDialog(filenameWidth)

        then: "Check file was not uploaded"
        assert !checkImageWasSpecified()

        and: "Error message validation"
        String actualMessageText = getErrorMessageFromImageErrorUploadDialog();
        assert actualMessageText.replaceAll("\\W","").equals(expectedTextWidth.replaceAll("\\W","")) :
                "Actual error text (" + actualMessageText + ") does not equal to expected (" + expectedTextWidth +")"

        where:
        filenameWidth = "width_exceed_banner.jpeg"
        expectedTextWidth = "The expected banner size is 1440x750 - the banner you uploaded exceeds the Width!"
        position = "home top 2"
    }

}
