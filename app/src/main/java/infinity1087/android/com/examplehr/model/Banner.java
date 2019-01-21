package infinity1087.android.com.examplehr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Banner {

    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("ResponseData")
    @Expose
    private List<BannerResults> responseData = null;
    @SerializedName("ResponseMsg")
    @Expose
    private String responseMsg;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<BannerResults> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<BannerResults> responseData) {
        this.responseData = responseData;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

}