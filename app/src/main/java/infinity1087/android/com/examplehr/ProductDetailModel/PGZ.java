package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PGZ implements Serializable {
    @SerializedName("ProductGroupId")
    @Expose
    private Integer productGroupId;
    @SerializedName("ProductGroupName")
    @Expose
    private Object productGroupName;
    @SerializedName("ProductGroupIcon")
    @Expose
    private Object productGroupIcon;
    @SerializedName("ProductGroupImage")
    @Expose
    private Object productGroupImage;
    @SerializedName("ProductGroupLink")
    @Expose
    private Object productGroupLink;
    @SerializedName("ProductGroupBannerImage")
    @Expose
    private Object productGroupBannerImage;
    @SerializedName("ProductGroupBannerLink")
    @Expose
    private Object productGroupBannerLink;
    @SerializedName("IsDisplayHome")
    @Expose
    private Object isDisplayHome;
    @SerializedName("IsActive")
    @Expose
    private Object isActive;
    @SerializedName("IsDisplay")
    @Expose
    private Object isDisplay;
    @SerializedName("IsAddedOn")
    @Expose
    private Object isAddedOn;
    @SerializedName("IsUpdatedOn")
    @Expose
    private Object isUpdatedOn;
    @SerializedName("CreatedBy")
    @Expose
    private Object createdBy;
    @SerializedName("UpdatedBy")
    @Expose
    private Object updatedBy;

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }

    public Object getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(Object productGroupName) {
        this.productGroupName = productGroupName;
    }

    public Object getProductGroupIcon() {
        return productGroupIcon;
    }

    public void setProductGroupIcon(Object productGroupIcon) {
        this.productGroupIcon = productGroupIcon;
    }

    public Object getProductGroupImage() {
        return productGroupImage;
    }

    public void setProductGroupImage(Object productGroupImage) {
        this.productGroupImage = productGroupImage;
    }

    public Object getProductGroupLink() {
        return productGroupLink;
    }

    public void setProductGroupLink(Object productGroupLink) {
        this.productGroupLink = productGroupLink;
    }

    public Object getProductGroupBannerImage() {
        return productGroupBannerImage;
    }

    public void setProductGroupBannerImage(Object productGroupBannerImage) {
        this.productGroupBannerImage = productGroupBannerImage;
    }

    public Object getProductGroupBannerLink() {
        return productGroupBannerLink;
    }

    public void setProductGroupBannerLink(Object productGroupBannerLink) {
        this.productGroupBannerLink = productGroupBannerLink;
    }

    public Object getIsDisplayHome() {
        return isDisplayHome;
    }

    public void setIsDisplayHome(Object isDisplayHome) {
        this.isDisplayHome = isDisplayHome;
    }

    public Object getIsActive() {
        return isActive;
    }

    public void setIsActive(Object isActive) {
        this.isActive = isActive;
    }

    public Object getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Object isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Object getIsAddedOn() {
        return isAddedOn;
    }

    public void setIsAddedOn(Object isAddedOn) {
        this.isAddedOn = isAddedOn;
    }

    public Object getIsUpdatedOn() {
        return isUpdatedOn;
    }

    public void setIsUpdatedOn(Object isUpdatedOn) {
        this.isUpdatedOn = isUpdatedOn;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

}
