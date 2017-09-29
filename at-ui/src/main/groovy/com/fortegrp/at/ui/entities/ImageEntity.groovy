package com.fortegrp.at.ui.entities

/**
 * Class represent Image object
 */
class ImageEntity {
    String fileName;
    String group;
    String locator;

    ImageEntity(String fileName, String group, String locator) {
        this.fileName = fileName
        this.group = group
        this.locator = locator
    }

    ImageEntity(Object json) {
        this.fileName = json.fileName
        this.group = json.group
        this.locator = json.locator
    }

    String getFileName() {
        return fileName
    }

    void setFileName(String fileName) {
        this.fileName = fileName
    }

    String getGroup() {
        return group
    }

    void setGroup(String group) {
        this.group = group
    }

    String getLocator() {
        return locator
    }

    void setLocator(String locator) {
        this.locator = locator
    }

}
