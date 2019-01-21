package infinity1087.android.com.examplehr.Client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExClient {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("ResponseData")
    @Expose
    private ResClient responseData;
    @SerializedName("ResponseMsg")
    @Expose
    private String responseMsg;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public ResClient getResponseData() {
        return responseData;
    }

    public void setResponseData(ResClient responseData) {
        this.responseData = responseData;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
