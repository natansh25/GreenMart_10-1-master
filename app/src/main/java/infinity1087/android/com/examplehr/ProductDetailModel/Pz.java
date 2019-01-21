package infinity1087.android.com.examplehr.ProductDetailModel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity(tableName = "movie_table")
public class Pz implements Serializable {
    @PrimaryKey
    @SerializedName("ProductId")
    @Expose
    private Integer productId;
    @SerializedName("ProductGroupId")
    @Expose
    private Integer productGroupId;
    @SerializedName("BrandId")
    @Expose
    private Integer brandId;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("ProductDescription")
    @Expose
    private String productDescription;
    @SerializedName("ProductCode")
    @Expose
    private String productCode;
    @SerializedName("ProductImage")
    @Expose
    private String productImage;
    @SerializedName("OfferText")
    @Expose
    private String offerText;
    @SerializedName("IsCombo")
    @Expose
    private Boolean isCombo;
    @SerializedName("IsSeasonal")
    @Expose
    private Boolean isSeasonal;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public Boolean getIsCombo() {
        return isCombo;
    }

    public void setIsCombo(Boolean isCombo) {
        this.isCombo = isCombo;
    }

    public Boolean getIsSeasonal() {
        return isSeasonal;
    }

    public void setIsSeasonal(Boolean isSeasonal) {
        this.isSeasonal = isSeasonal;
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