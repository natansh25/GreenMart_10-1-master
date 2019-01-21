package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PPZ implements Serializable {
    @SerializedName("ProductPrametersId")
    @Expose
    private Integer productPrametersId;
    @SerializedName("ProductId")
    @Expose
    private Integer productId;
    @SerializedName("Weight")
    @Expose
    private Double weight;
    @SerializedName("UnitId")
    @Expose
    private Integer unitId;
    @SerializedName("BasicCost")
    @Expose
    private Double basicCost;
    @SerializedName("IsTaxCalculate")
    @Expose
    private Boolean isTaxCalculate;
    @SerializedName("TaxPercentage")
    @Expose
    private Double taxPercentage;
    @SerializedName("MRP")
    @Expose
    private Double mRP;
    @SerializedName("SellCost")
    @Expose
    private Double sellCost;
    @SerializedName("CheckeredCost")
    @Expose
    private Double checkeredCost;
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

    public Integer getProductPrametersId() {
        return productPrametersId;
    }

    public void setProductPrametersId(Integer productPrametersId) {
        this.productPrametersId = productPrametersId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Double getBasicCost() {
        return basicCost;
    }

    public void setBasicCost(Double basicCost) {
        this.basicCost = basicCost;
    }

    public Boolean getIsTaxCalculate() {
        return isTaxCalculate;
    }

    public void setIsTaxCalculate(Boolean isTaxCalculate) {
        this.isTaxCalculate = isTaxCalculate;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Double getMRP() {
        return mRP;
    }

    public void setMRP(Double mRP) {
        this.mRP = mRP;
    }

    public Double getSellCost() {
        return sellCost;
    }

    public void setSellCost(Double sellCost) {
        this.sellCost = sellCost;
    }

    public Double getCheckeredCost() {
        return checkeredCost;
    }

    public void setCheckeredCost(Double checkeredCost) {
        this.checkeredCost = checkeredCost;
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
