package infinity1087.android.com.examplehr.Client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResClient {
    @SerializedName("$id")
    @Expose
    private String $id;
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
    @SerializedName("PincodeId")
    @Expose
    private Integer pincodeId;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("MembershipCode")
    @Expose
    private Object membershipCode;
    @SerializedName("MembershipIssueDate")
    @Expose
    private Object membershipIssueDate;
    @SerializedName("MembershipExpiryDate")
    @Expose
    private Object membershipExpiryDate;
    @SerializedName("MemberShipUpdatedOn")
    @Expose
    private Object memberShipUpdatedOn;
    @SerializedName("MemberShipQRCode")
    @Expose
    private Object memberShipQRCode;
    @SerializedName("ReferredByTypeID")
    @Expose
    private Object referredByTypeID;
    @SerializedName("ReferredByID")
    @Expose
    private Object referredByID;
    @SerializedName("LastPasswordUpdatedOn")
    @Expose
    private Object lastPasswordUpdatedOn;
    @SerializedName("TempMembershipCode")
    @Expose
    private Object tempMembershipCode;
    @SerializedName("AddedOn")
    @Expose
    private String addedOn;
    @SerializedName("UpdatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsSignInNormal")
    @Expose
    private Boolean isSignInNormal;
    @SerializedName("IsSignInGoogle")
    @Expose
    private Boolean isSignInGoogle;
    @SerializedName("IsSignInFacebook")
    @Expose
    private Boolean isSignInFacebook;
    @SerializedName("FacebookId")
    @Expose
    private String facebookId;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

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

    public Integer getPincodeId() {
        return pincodeId;
    }

    public void setPincodeId(Integer pincodeId) {
        this.pincodeId = pincodeId;
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

    public Object getMembershipCode() {
        return membershipCode;
    }

    public void setMembershipCode(Object membershipCode) {
        this.membershipCode = membershipCode;
    }

    public Object getMembershipIssueDate() {
        return membershipIssueDate;
    }

    public void setMembershipIssueDate(Object membershipIssueDate) {
        this.membershipIssueDate = membershipIssueDate;
    }

    public Object getMembershipExpiryDate() {
        return membershipExpiryDate;
    }

    public void setMembershipExpiryDate(Object membershipExpiryDate) {
        this.membershipExpiryDate = membershipExpiryDate;
    }

    public Object getMemberShipUpdatedOn() {
        return memberShipUpdatedOn;
    }

    public void setMemberShipUpdatedOn(Object memberShipUpdatedOn) {
        this.memberShipUpdatedOn = memberShipUpdatedOn;
    }

    public Object getMemberShipQRCode() {
        return memberShipQRCode;
    }

    public void setMemberShipQRCode(Object memberShipQRCode) {
        this.memberShipQRCode = memberShipQRCode;
    }

    public Object getReferredByTypeID() {
        return referredByTypeID;
    }

    public void setReferredByTypeID(Object referredByTypeID) {
        this.referredByTypeID = referredByTypeID;
    }

    public Object getReferredByID() {
        return referredByID;
    }

    public void setReferredByID(Object referredByID) {
        this.referredByID = referredByID;
    }

    public Object getLastPasswordUpdatedOn() {
        return lastPasswordUpdatedOn;
    }

    public void setLastPasswordUpdatedOn(Object lastPasswordUpdatedOn) {
        this.lastPasswordUpdatedOn = lastPasswordUpdatedOn;
    }

    public Object getTempMembershipCode() {
        return tempMembershipCode;
    }

    public void setTempMembershipCode(Object tempMembershipCode) {
        this.tempMembershipCode = tempMembershipCode;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public Boolean getIsSignInFacebook() {
        return isSignInFacebook;
    }

    public void setIsSignInFacebook(Boolean isSignInFacebook) {
        this.isSignInFacebook = isSignInFacebook;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}
