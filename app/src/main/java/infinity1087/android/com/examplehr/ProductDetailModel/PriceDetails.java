package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class PriceDetails  implements Serializable {

    @SerializedName("PP")
    @Expose
    private PPZ pP;
    @SerializedName("PU")
    @Expose
    private PUZ pU;

    public PPZ getPP() {
        return pP;
    }

    public void setPP(PPZ pP) {
        this.pP = pP;
    }

    public PUZ getPU() {
        return pU;
    }

    public void setPU(PUZ pU) {
        this.pU = pU;
    }

}
