package com.fortegrp.at.ui.entities

/**
 * Enum represents types of Recepients
 */
enum RecipientsTypes {
    EVERYONE("everyone"),
    SPECIFIC_USER_SEGMENT("specificsegment")

    String value;

    RecipientsTypes(String value){
        this.value = value
    }

    String getValue() {
        return value
    }
}