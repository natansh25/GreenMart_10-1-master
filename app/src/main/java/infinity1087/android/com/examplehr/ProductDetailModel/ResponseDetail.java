package infinity1087.android.com.examplehr.ProductDetailModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;


public class ResponseDetail implements Serializable {

    @SerializedName("P")
    @Expose
    private Pz p;
    @SerializedName("PG")
    @Expose
    private PGZ pG;
    @SerializedName("B")
    @Expose
    private B b;
    @SerializedName("PriceDetail")
    @Expose
    private List<PriceDetails> priceDetail = null;

    public Pz getP() {
        return p;
    }

    public void setP(Pz p) {
        this.p = p;
    }

    public PGZ getPG() {
        return pG;
    }

    public void setPG(PGZ pG) {
        this.pG = pG;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public List<PriceDetails> getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(List<PriceDetails> priceDetail) {
        this.priceDetail = priceDetail;
    }


    public static final Comparator<ResponseDetail> BY_NAME_Alphabetacally = new Comparator<ResponseDetail>() {
        @Override
        public int compare(ResponseDetail responseDatum, ResponseDetail t1) {

            return responseDatum.getP().getProductName().compareTo(t1.getP().getProductName());
        }
    };


    public static final Comparator<ResponseDetail> BY_PRICE = new Comparator<ResponseDetail>() {
        @Override
        public int compare(ResponseDetail responseDatum, ResponseDetail t1) {

            return responseDatum.priceDetail.get(0).getPP().getBasicCost().compareTo(t1.priceDetail.get(0).getPP().getBasicCost());
        }
    };

    public static final Comparator<ResponseDetail> BY_NAME_Desending = new Comparator<ResponseDetail>() {
        @Override
        public int compare(ResponseDetail responseDatum, ResponseDetail t1) {

            return t1.getP().getProductName().compareTo(responseDatum.getP().getProductName());
        }
    };


}
