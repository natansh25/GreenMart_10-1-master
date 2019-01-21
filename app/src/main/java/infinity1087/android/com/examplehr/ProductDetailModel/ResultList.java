package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResultList implements Serializable {

    @SerializedName("ResponseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("ResponseData")
    @Expose
    private List<ResponseDetail> responseData = null;
    @SerializedName("ResponseMsg")
    @Expose
    private String responseMsg;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<ResponseDetail> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseDetail> responseData) {
        this.responseData = responseData;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

}
