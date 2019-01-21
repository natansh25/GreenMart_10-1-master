package infinity1087.android.com.examplehr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SwaggerPost {


    @SerializedName("ClientId")
    @Expose
    private Integer clientId;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("LastPasswordUpdatedOn")
    @Expose
    private String lastPasswordUpdatedOn;
    @SerializedName("IsSignInNormal")
    @Expose
    private Boolean isSignInNormal;
    @SerializedName("IsSignInGoogle")
    @Expose
    private Boolean isSignInGoogle;
    @SerializedName("GoogleID")
    @Expose
    private String googleID;
    @SerializedName("IsSignInFacebook")
    @Expose
    private Boolean isSignInFacebook;
    @SerializedName("FacebookID")
    @Expose
    private String facebookID;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastPasswordUpdatedOn() {
        return lastPasswordUpdatedOn;
    }

    public void setLastPasswordUpdatedOn(String lastPasswordUpdatedOn) {
        this.lastPasswordUpdatedOn = lastPasswordUpdatedOn;
    }

    public Boolean getIsSignInNormal() {
        return isSignInNormal;
    }

    public void setIsSignInNormal(Boolean isSignInNormal) {
        this.isSignInNormal = isSignInNormal;
    }

    public Boolean getIsSignInGoogle() {
        return isSignInGoogle;
    }

    public void setIsSignInGoogle(Boolean isSignInGoogle) {
        this.isSignInGoogle = isSignInGoogle;
    }

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public Boolean getIsSignInFacebook() {
        return isSignInFacebook;
    }

    public void setIsSignInFacebook(Boolean isSignInFacebook) {
        this.isSignInFacebook = isSignInFacebook;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
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

