package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class B implements Serializable {

    @SerializedName("BrandId")
    @Expose
    private Integer brandId;
    @SerializedName("BrandName")
    @Expose
    private Object brandName;
    @SerializedName("BrandImage")
    @Expose
    private Object brandImage;
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Object getBrandName() {
        return brandName;
    }

    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    public Object getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(Object brandImage) {
        this.brandImage = brandImage;
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