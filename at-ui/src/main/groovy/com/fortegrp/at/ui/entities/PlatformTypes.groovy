package com.fortegrp.at.ui.entities

enum PlatformTypes {
    ANDROID("android"),
    IPHONE("iphone"),
    ANDROID_IPHONE("android_iphone")

    String value;

    PlatformTypes(String value){
        this.value = value
    }

    String getValue() {
        return value
    }

}