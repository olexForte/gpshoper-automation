package com.fortegrp.at.ui.content

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

        positionsDropDown{$(By.xpath("//div[text() = 'Positions']/following-sibling::div"))}
        positionsDropDownItem{ item -> $(By.xpath("//div[@data-reactroot]//span//div[text()='" + item + "']"))}

        actionSelect{$(By.xpath("//div[text() = 'Action Type and Value']/following-sibling::div"))}
        dropDownOption{text -> $(By.xpath("//span[@tabindex]//div[text() = '" + text +"']))}"))}

        //upload images dialog
        uploadButton{$("input#uploadImage")}
        useUploadedImagesButton{$(By.xpath("//div[contains(text(),'Image Uploaded')]"))}
        useNewImageButton{$(By.xpath("//div[contains(text(),'New Image')]"))}

        cancelDialogButton{$(By.xpath("(//div/span[contains(text(),'Cancel')])[last()]"))}

        //use existing dialog button
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
        imageInUseImageDialog{ id -> $(By.xpath("//img[contains(@src,'" + id + "')][not(contains(@style,'width: 100%'))]"))}

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
        positionsDropDown.click();
        positionsDropDownItem(item).click();
    }

    /**
     * Click on Upload button
     * @return
     */
    def clickOnUploadButton(){
        uploadButton.click()
    }

    def uploadFileFromDialog(){ // TODO
        $(org.openqa.selenium.By.xpath("//input[@type='file']/../div"))[0].click()
        $("input[type='file']")[0].value("test/data/image3.jpeg")

    }

    def clickOnNewImageButton(){
        useNewImageButton.click()
    }

}
