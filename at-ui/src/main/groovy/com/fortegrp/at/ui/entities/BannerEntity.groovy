package com.fortegrp.at.ui.entities

import com.fortegrp.at.common.utils.DateUtils

/**
 * Entity for Banner object
 */
class BannerEntity {

    String title;
    PlatformTypes platform
    String position;
    Date startDate;
    Date endDate;
    String startTime;
    String endTime;
    String actionType;
    String actionValue;
    String[] segments;
    RecipientsTypes recipients;
    ImageEntity image

    ImageEntity getImage() {
        return image
    }

    void setImage(ImageEntity image) {
        this.image = image
    }
;

    RecipientsTypes getRecipients() {
        return recipients
    }

    void setRecipients(RecipientsTypes recipients) {
        this.recipients = recipients
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    PlatformTypes getPlatform() {
        return platform
    }

    void setPlatform(PlatformTypes platform) {
        this.platform = platform
    }

    String getPosition() {
        return position
    }

    void setPosition(String position) {
        this.position = position
    }

    Date getStartDate() {
        return startDate
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate
    }

    Date getEndDate() {
        return endDate
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate
    }

    String getStartTime() {
        return startTime
    }

    void setStartTime(String startTime) {
        this.startTime = startTime
    }

    String getEndTime() {
        return endTime
    }

    void setEndTime(String endTime) {
        this.endTime = endTime
    }

    String getActionType() {
        return actionType
    }

    void setActionType(String actionType) {
        this.actionType = actionType
    }

    String getActionValue() {
        return actionValue
    }

    void setActionValue(String actionValue) {
        this.actionValue = actionValue
    }

    String[] getSegments() {
        return segments
    }

    void setSegments(String[] segments) {
        this.segments = segments
    }

    BannerEntity(String title, PlatformTypes platform, String position, Date startDate, Date endDate, String startTime, String endTime, String actionType, String actionValue, String[] segments) {
        this.title = title
        this.platform = platform
        this.position = position
        this.startDate = startDate
        this.endDate = endDate
        this.startTime = startTime
        this.endTime = endTime
        this.actionType = actionType
        this.actionValue = actionValue
        this.segments = segments
    }

    BannerEntity(BannerEntityBuilder builder){
        this.title = builder.title
        this.platform = builder.platform
        this.position = builder.position
        this.startDate = builder.startDate
        this.endDate = builder.endDate
        this.startTime = builder.startTime
        this.endTime = builder.endTime
        this.actionType = builder.actionType
        this.actionValue = builder.actionValue
        this.segments = builder.segments
    }

    public static class BannerEntityBuilder {
        String title;
        PlatformTypes platform
        String position;
        Date startDate;
        Date endDate;
        String startTime;
        String endTime;
        String actionType;
        String actionValue;
        String[] segments;
        RecipientsTypes recipients;
        ImageEntity image


        public BannerEntityBuilder( Object json){
            this.title = json.title
            this.platform = PlatformTypes.valueOf(json.platform)
            this.position = json.position
            this.startDate = DateUtils.getDateFromString(json.startDate)
            this.endDate = DateUtils.getDateFromString(json.endDate)
            this.startTime = json.startTime
            this.endTime = json.endTime
            this.actionType = json.actionType
            this.actionValue = json.actionValue
            this.segments = json.segments
            this.recipients = RecipientsTypes.valueOf(json.recipients);
            this.image = new ImageEntity(json.image)
        }

        public BannerEntityBuilder () {

        }

        BannerEntityBuilder setTitle (String title) {
            this.title = title
            this
        }

        BannerEntityBuilder setPlatform(PlatformTypes platform) {
            this.platform = platform
            this
        }

        BannerEntityBuilder setPosition(String position) {
            this.position = position
            this
        }

        BannerEntityBuilder setStartDate(Date startDate) {
            this.startDate = startDate
            this
        }

        BannerEntityBuilder setEndDate(Date endDate) {
            this.endDate = endDate
            this
        }

        BannerEntityBuilder setStartTime(String startTime) {
            this.startTime = startTime
            this
        }

        BannerEntityBuilder setEndTime(String endTime) {
            this.endTime = endTime
            this
        }

        BannerEntityBuilder setActionType(String actionType) {
            this.actionType = actionType
            this
        }

        BannerEntityBuilder setActionValue(String actionValue) {
            this.actionValue = actionValue
            this
        }

        BannerEntityBuilder setSegments(String[] segments) {
            this.segments = segments
            this
        }
        BannerEntityBuilder setRecipients(RecipientsTypes recipients) {
            this.recipients = recipients
            this
        }

        BannerEntityBuilder setImage(ImageEntity image) {
            this.image = image
            this
        }
        public BannerEntity build()
        {
            return new BannerEntity(this);
        }

    }
}
