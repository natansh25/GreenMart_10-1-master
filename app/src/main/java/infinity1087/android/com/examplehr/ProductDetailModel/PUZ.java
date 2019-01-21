package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PUZ implements Serializable {
    @SerializedName("UnitId")
    @Expose
    private Integer unitId;
    @SerializedName("UnitName")
    @Expose
    private String unitName;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
