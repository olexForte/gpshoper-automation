package com.fortegrp.at.ui.content

import org.junit.Assert
import org.openqa.selenium.By

/**
 * Created by Admin on 9/18/2017.
 */
class BannerCreateEditPage extends BaseControlCenterPage{

    static at = {
        waitFor {
            phoneSection.displayed
            js.('document.readyState') == 'complete'
        }
       // waitForPageLoadingBasedOnSpinner()
    }

    static content = {
        saveButton(wait:true){$("a.saveButton")}
        cancelButton(wait:true){$("a.cancelButton")}
        phoneSection{$("div.case")}

        //create banner fields
        platformSelectors{$(By.xpath("//div[count(button) = 3]/button"))}
        bannerTitleField{$(By.xpath("//div[./span[text() = 'Banner Title']]/following-sibling::div/input"))}

        startDateSelect{$(By.xpath("//input[contains(@id, 'SelectStartDate')]"))}
        startTimeSelect{$(By.xpath("//input[contains(@id, 'SelectStartTime')]"))}
        endDateSelect{$(By.xpath("//input[contains(@id, 'SelectEndDate')]"))}
        endTimeSelect{$(By.xpath("//input[contains(@id, 'SelectEndTime')]"))}

        //callendar
        pickDateByDayInCallendar{day -> $(By.xpath("//button/span[text()='" + day + "']"))} // ("//div[text()='October 2017']/../../../../..//button/span[text()='1']")
        pickDatePreviousMonthButton{$(By.xpath("//div[contains(@style,'display: flex; flex-direction: column;')]/div[contains(@style,'display: flex')]/div[contains(@style,'display: flex')]//button"))}
        pickDateNextMonthButton{$(By.xpath("//div[contains(@style,'display: flex; flex-direction: column;')]/div[contains(@style,'display: flex')]/div[contains(@style,'display: flex')]//button"))}
        callendarOKButton{$(By.xpath("//button/div/span[text()='OK']"))}
        getCurentDateFromCallendar{} // TODO

        //time picker
        timePickerByItemText{item -> $(By.xpath("//div[contains(@style,'content-box')]//span[text()='" + item + "']"))}
        timePickerOKButton{$(By.xpath("//button/div/span[text()='OK']"))}
        getCurrentTimeFRomTimePicker{}//TODO

        bannerScreenImage(wait:true, required:false){$("div.screen img:last-child")}

        positionsDropDownButton(wait:true){$(By.xpath("//div[text() = 'Positions']/following-sibling::div//button"))}
        positionsDropDownItem(wait:true){ item -> $(By.xpath("//div[@data-reactroot]//span//div[text()='" + item + "']"))}

        actionTypeAndValueDropDownButton{$(By.xpath("//div[text() = 'Action Type and Value']/following-sibling::div//button"))}
        actionTypeAndValueDropDownOption{text -> $(By.xpath("//span[@tabindex]//div[text() = '" + text +"']))}"))}


        //types of Action type
        productInput{"input#actionTypeProduct"}
        URLInput{"input#actionTypeURL"}
        searchInput{$("input#actionTypeSearch")}

        sectionDropDownButton{$(By.xpath("//div[text() = 'Section']/following-sibling::div//button"))}
        sectionDropDownOption{text -> $(By.xpath("//span[@tabindex]//div[text() = '" + text +"']))}"))}

        resetButton{$("button.reset-button")}

        //recepients
        recepientsEveryone{$("input[name='segment'][value='everyone']")}
        recepientsSpecificUserSegment{$("input[name='segment'][value='userSegment']")}

        //specific segments
        segmentByDescription{description -> $(By.xpath("//div[@class='bannerTable-second-row']//span[text()='" + description + "']/../input"))}

        //upload images dialog
        uploadButton{$("input#uploadImage")}
        useUploadedImagesButton{$(By.xpath("//div[contains(text(),'Image Uploaded')]"))}
        useNewImageButton{$(By.xpath("//div[contains(text(),'New Image')]"))}

        cancelDialogButton{$(By.xpath("(//div/span[contains(text(),'Cancel')])[last()]"))}

        //use existing dialog button
        imagesButtonTypeOnUploadDialog{ type -> $(By.xpath("//button/div/div[text()='" + type + "']"))}
        liveImagesButton{$(By.xpath("//button/div/div[text()='LIVE']"))}
        scheduledImagesButton{$(By.xpath("//button/div/div[text()='SCHEDULED']"))}
        expiredImagesButton {$(By.xpath("//button/div/div[text()='EXPIRED']"))}

        //use image dialog
        uploadImageDialog{$(By.xpath("//div/h3[text()='Upload Image']/../../div"))}
        uploadDialogImages{$(By.xpath("//div/h3[text()='Upload Image']/../../div//img"))}
        useImageButton{$(By.xpath("//div/span[text()='USE']"))}

        //drop drop image
        uploadImageDialog{$(By.xpath("//div/h3[text()='Upload Image']/../../div"))}

        // image in Use Image dialog
        imageInUseImageDialog(wait:true){ id -> $(By.xpath("//img[contains(@src,'" + id + "')][not(contains(@style,'width: 100%'))]"))}

        // upload image dialog
        uploadImageDialogFile{ $("input[type='file']") }
        //$(org.openqa.selenium.By.xpath("//input[@type='file']/../div"))[0].click();$("input[type='file']")[0].value("test/data/image3.jpeg")
    }

    /**
     * Click on Save Banner button
     * @return
     */
    def clickSaveButton()
    {
        saveButton.click()
    }

    /**
     * Click on Cancel Banner button
     * @return
     */
    def clickCancelButton()
    {
        cancelButton.click()
    }

    /**
     * Set Position dropdown
     * @param item position
     * @return
     */
    def positionsDropDown(item){
        //TODO wait required
        positionsDropDownButton.click();
        positionsDropDownItem(item).click();
        waitFor{
            bannerScreenImage.isDisplayed()
        }
    }

    /**
     * Click on Upload button
     * @return
     */
    def clickOnUploadButton(){
        uploadButton.click()
        waitFor{
            useNewImageButton.isDisplayed()
        }
    }

    /**
     * In Upload Image dialog select option New Image
     * @return
     */
    def clickOnNewImageButton(){
        useNewImageButton.click()
    }

    /**
     * In Upload Image dialog select option Image Uploaded
     * @return
     */
    def clickOnUseExistingImageButton(){
        useUploadedImagesButton.click();
    }

    /**
     * Upload file from Dialog
     * @return
     */
    def uploadFileFromDialog(filename){ // TODO
        //$(org.openqa.selenium.By.xpath("//input[@type='file']/../div"))[0].click()
        //$("input[type='file']")[0].value("test/data/" + filename)
        $("input[type='file']")[0] = "test/data/" + filename
    }

    /**
     * Check that Banner has assigned image
     */
    def checkImageWasSpecified(){
        Assert.assertFalse("Existing locator is blank", getCurrentBannerImageSrcLocator().equals(""))
    }

    /**
     * Check that Banner has expected assigned image
     * @param srcLocator expected locator
     */
    def checkExpectedImageWasSpecified(expectedLocator){
        actualLocator = getCurrentBannerImageSrcLocator()
        Assert.assertTrue("Actual locator (" + actualLocator + ") does not equal to expected '" + srcLocator + "'", actualLocator.equals(expectedLocator))
    }

    def getCurrentBannerImageSrcLocator(){
        //TODO get SRC attr from Image and return part of it that can be locator
        try {
            locator = (bannerScreenImage.getAttribute("src") =~ /.*md5\/(.*)\/300\/300/)[0][1]
        } catch (Exception e){
            locator = ""
        }
        locator
    }

    def hoverMouseOverImageWithSrcLocator(locator){
        $(By.xpath("//img[contains(@src,'" + locator + "')][not(contains(@style,'width: 100%'))]")).click()
       // imageInUseImageDialog(locator).click()
    }

    def selectExistingImageGroup(group){
        imagesButtonTypeOnUploadDialog(group).click()
    }

    def selectExistingImage(imageLocator){
        hoverMouseOverImageWithSrcLocator(imageLocator)
        useImageButton.click()
    }
}
