package infinity1087.android.com.examplehr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerResults {

    @SerializedName("BannerId")
    @Expose
    private Integer bannerId;
    @SerializedName("BannerImage")
    @Expose
    private String bannerImage;
    @SerializedName("BannerLink")
    @Expose
    private String bannerLink;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsDisplay")
    @Expose
    private Boolean isDisplay;
    @SerializedName("IsAddedOn")
    @Expose
    private String isAddedOn;
    @SerializedName("IsUpdatedOn")
    @Expose
    private String isUpdatedOn;
    @SerializedName("CreatedBy")
    @Expose
    private Integer createdBy;
    @SerializedName("UpdatedBy")
    @Expose
    private Integer updatedBy;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerLink() {
        return bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getIsAddedOn() {
        return isAddedOn;
    }

    public void setIsAddedOn(String isAddedOn) {
        this.isAddedOn = isAddedOn;
    }

    public String getIsUpdatedOn() {
        return isUpdatedOn;
    }

    public void setIsUpdatedOn(String isUpdatedOn) {
        this.isUpdatedOn = isUpdatedOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

}

