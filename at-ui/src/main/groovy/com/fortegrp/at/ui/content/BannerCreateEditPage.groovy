package com.fortegrp.at.ui.content

import com.fortegrp.at.ui.utils.SrcLocatorProcessor
import geb.navigator.Navigator
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.WebElement

/**
 * Created by Admin on 9/18/2017.
 */
class BannerCreateEditPage extends BaseControlCenterPage{

    static at = {
        waitFor {
            phoneSection.displayed
            !loaderSpinner.displayed
            js.('document.readyState') == 'complete'
        }
       // waitForPageLoadingBasedOnSpinner()
    }

    static content = {
        saveButton(wait:true){$("a.saveButton")}
        cancelButton(wait:true){$("a.cancelButton")}
        phoneSection{$("div.case")}

        requiredSizeTooltip{ $(By.xpath("//div[text()='* Required Size']/label/input"))}
        bannerDetailsButton(wait:true, required:false){ $("button.bannerDetails")}

        //Platform Toggles
        //e.g. search for androidToggle(true) if you toggle is currently selected, androidToggle(false) if not
        androidToggle(required: false){selected-> if (selected)$("img", 'src': "../../static/img/banner_toggle_android_blue.png") else $("img", 'src': "../../static/img/banner_toggle_android.png")}
        iOsToggle(required: false){selected-> if (selected)$("img", 'src': "../../static/img/banner_toggle_ios_blue.png") else $("img", 'src': "../../static/img/banner_toggle_ios.png")}
        bothPlatformsToggle(required: false){selected-> if (selected)$("img", 'src': "../../static/img/banner_toggle_ios_android_blue.png") else $("img", 'src': "../../static/img/banner_toggle_ios_android.png")}

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

        //specific User segments
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

        // image in Use Image dialog
        imageInUseImageDialog(wait:true){ id -> $(By.xpath("//img[contains(@src,'" + id + "')][not(contains(@style,'width: 100%'))]"))}

        // upload image dialog
        uploadImageDialogFile{ $("input[type='file']") }
        //$(org.openqa.selenium.By.xpath("//input[@type='file']/../div"))[0].click();$("input[type='file']")[0].value("test/data/image3.jpeg")

        bannerWasCreatedSuccessfullyMessage{$(By.xpath("//h3[text()='Adding Banner Succeeded']"))}
        bannerCreationErrorMessage{$(By.xpath("//h3[text()='IMAGE UPLOAD ERRORS']"))}
        // The expected banner size is 1440x750 - the banner you uploaded exceeds the Height!
        bannerSubmissionError{$(By.xpath("//h3[text()='SUBMISSION ERRORS']"))}

        OKButtonOnMessageDialog{$(By.xpath("//button/div/span[text()='Ok']"))}

    }

    /**
     * get Banner screen image - workaround for problem with late processing of items
      */
    def getBannerScreenImage(){
        $("div.screen img:last-child")
    };

    /**
     * Clicks on Use button (using JS to get focus on element)
     * @return
     */
    def clickUseImageButton(){
        browser.driver.executeScript("arguments[0].focus()", $(By.xpath("//span[text()='USE']/../../../..//button")).firstElement())
        $(By.xpath("//span[text()='USE']/../../../..//button")).click()
    }

    def setBannerTitle(title)
    {
        waitFor {
            bannerTitleField.displayed
            bannerTitleField.value(title)
        }
    }

    //todo: finish the function
    def setStartDate(date)
    {
        startDateSelect.click()

        def currentCalendarMonthYear = new Date().parse( "MMM yyyy", 'e.g. September 2017')
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
            getBannerScreenImage().isDisplayed()
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
     * Selects one of the Platform toggles
     * @param toggle Accepts either of 'android'/'ios'/'both'
     */
    def selectPlatformToggle(toggle)
    {
        //todo: replace println if possible
        switch (toggle){
            case 'android':
                if(androidToggle(true).displayed){
                    println(toggle + ' toggle is already selected')
                    break
                }else {
                    androidToggle(false).click()
                    waitFor {androidToggle(true).displayed}
                    println(toggle + ' toggle selected')
                    break
                }
            case 'ios':
                if(iOsToggle(true).displayed){
                    println(toggle + ' toggle is already selected')
                    break
                }else {
                    iOsToggle(false).click()
                    waitFor {iOsToggle(true).displayed}
                    println(toggle + ' toggle is selected')
                    break
                }
            case 'both':
                if(bothPlatformsToggle(true).displayed){
                    println(toggle + ' toggle is already selected')
                    break
                }else {
                    bothPlatformsToggle(false).click()
                    waitFor {bothPlatformsToggle(true).displayed}
                    println(toggle + ' toggle selected')
                    break
                }
        }
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
        assert !getCurrentBannerImageSrcLocator().equals("") : "Existing locator is blank"
    }

    /**
     * Get src locator for currently selected Banner image
     * @return locator src locator
     */
    def getCurrentBannerImageSrcLocator(){
        //TODO get SRC attr from Image and return part of it that can be locator
        String locator;
        try {
            locator = SrcLocatorProcessor.getLocatorFromSrc(getBannerScreenImage().getAttribute("src"))
        } catch (Exception e){
            locator = ""
        }
        locator
    }

    /**
     * Hover mouse over image with src locator
     * @param locator src locator
     * @return
     */
    def hoverMouseOverImageWithSrcLocator(locator){

        clickOnFirstImageInUploadedImagesDialog() //it makes one element Active - @class='hoverImage' instead of @class='hover'
        //Navigator[] listOfAllImagesOnActiveTabUploadedImagesDialog = $(By.xpath("//div[@class='hoverImage']/../../div//img"))

        Navigator requiredImage = $(By.xpath("//div[@class='hoverImage']/../../div//img[contains(@src,'" + locator + "')]"))

        if (!requiredImage.isDisplayed())
            throw new NotFoundException("Image with locator [" + locator + "] was not found in current tab")

        requiredImage.click() // activate image

        // move Down to see Use button
        interact {
            sendKeys(Keys.ARROW_DOWN)
        }
    }

    /**
     * Activtes first element on a Active tab on Uploaded Image dialog
     */
    def clickOnFirstImageInUploadedImagesDialog(){

        waitFor{
            !loaderSpinner.isDisplayed()
        }
        Navigator firstImageOnATab = $(By.xpath("(//div[@class='hover'][not(contains(@style,'width: 100%'))]//img)[1]"))

        interact{
            moveToElement(firstImageOnATab, 10, 10)
            click()
        }
    }

    /**
     * Select one of existing images group <br>(live, scheduled, expired)
     * @param group Live, Scheduled or Expired
     * @return
     */
    def selectExistingImageGroup(group){
        imagesButtonTypeOnUploadDialog(group).click()
    }

    /**
     * Select Image from Existing images dialog<br>
     *     Hover mouse over image and click 'USE'
     * @param imageLocator image locator
     * @return
     */
    def selectExistingImage(imageLocator){
        hoverMouseOverImageWithSrcLocator(imageLocator)
        clickUseImageButton()
    }

    def getRandomImageSrcLocatorFromListOfExistingImages(){

    }

    /**
     * Check that Banner was saved
     * @return 'true' if banner saved message was displayed
     */
    def wasBannerSaved(){
        waitFor{
            bannerWasCreatedSuccessfullyMessage.displayed
        }
        if (bannerWasCreatedSuccessfullyMessage.displayed){
            OKButtonOnMessageDialog.click()
            return true
        }
        else {
            return false
        }
    }

    /**
     * Returns Required Size tooltip content
     * @return content of tooltip
     */
    def getRequiredSizeTooltipText(){
        interact{
            moveToElement(requiredSizeTooltip)
        }
        StringBuffer text = new StringBuffer()
        $("div", text: "Image Size in Server").parent().$("div").each{text.append(it.text())};
        return  text.toString()
    }

    /**
     * Returns Banner Details tooltip content
     * @return content of tooltip
     */
    def getBannerDetailsTooltipText(){
        // TODO refresh element -  bannerDetailsButton.click()
        waitFor{
            $("button.bannerDetails").displayed
        }
        interact{
            sendKeys(Keys.PAGE_DOWN)
        }
        sleep(1000)
        $("button.bannerDetails").click()
        StringBuffer text = new StringBuffer()
        $("div", text: "Image Size in Server").parent().$("div").each{text.append(it.text())};
        return  text.toString()
    }

    def getErrorMessageFromSubmissionErrorsDialog( ){
        bannerSubmissionError.$()
    }
}
