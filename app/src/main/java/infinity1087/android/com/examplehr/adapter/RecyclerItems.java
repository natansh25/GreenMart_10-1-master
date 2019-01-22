package infinity1087.android.com.examplehr.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import infinity1087.android.com.examplehr.ProductDetailModel.PriceDetails;
import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation.RoundedTransformation;
import infinity1087.android.com.examplehr.ProductDetailModel.ResponseDetail;
import infinity1087.android.com.examplehr.DetailLayout;

public class RecyclerItems extends RecyclerView.Adapter<RecyclerItems.MyViewHolder> implements Filterable {

    // http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI

    List<ResponseDetail> mData;
    List<PriceDetails> mPricel;
    List<ResponseDetail> mDataFiltered;
    List<PriceDetails> mPricelFiltered;
    private AddToCartItemClickListner mOnClickListener;
    Context mContext;
    String  price;
    String image;


    public interface AddToCartItemClickListner {
        void onListItemClick(ResponseDetail responseDetail,String price);
        //void onButtonClick(int position);
    }

    public RecyclerItems(List<ResponseDetail> data, List<ResponseDetail> dataFiltered, DetailLayout context) {

        this.mData = data;
        mDataFiltered = dataFiltered;
        mContext = context;

    }

    public void setOnItemCliackListner(AddToCartItemClickListner onClickListener)
    {
        this.mOnClickListener=onClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .item_list_grossary_new, viewGroup, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final ResponseDetail datum = mDataFiltered.get(i);
        final PriceDetails details = datum.getPriceDetail().get(0);

        int size = datum.getPriceDetail().size();
        final List<String> mList = new ArrayList<>();

        //mList.clear();
        for (i = 0; i < size; i++) {

            PriceDetails details2 = datum.getPriceDetail().get(i);
            mList.add(String.valueOf(details2.getPP().getWeight() + " " + details2.getPU().getUnitName() + " - " + details2.getPP().getSellCost() + "₹"));

        }

        Log.d("oal", String.valueOf(Arrays.asList(mList)));

        myViewHolder.niceSpinner.attachDataSource(mList);
        myViewHolder.niceSpinner.setSelectedIndex(0);
        price= String.valueOf(myViewHolder.niceSpinner.getSelectedIndex());
        myViewHolder.txt_name.setText(datum.getP().getProductName());
        myViewHolder.txt_price.setText(String.valueOf(details.getPP().getBasicCost()) + "₹");
        myViewHolder.txt_offer.setText(String.valueOf(details.getPP().getCheckeredCost()) + "₹");

        Picasso.get()
                .load("http://image.barodaweb.net/api/EGreen/Magic/270/Product-" + datum.getP().getProductId() + "/" + datum.getP().getProductImage() + "/100")
                .transform(new RoundedTransformation(20, 0))
                .into(myViewHolder.imageView);

        myViewHolder.niceSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                PriceDetails details3 = datum.getPriceDetail().get(i);
                price=String.valueOf(details3.getPP().getBasicCost());
                myViewHolder.txt_price.setText(String.valueOf(details3.getPP().getBasicCost()) + "₹");
                myViewHolder.txt_offer.setText(String.valueOf(details3.getPP().getCheckeredCost()) + "₹");

            }
        });
    }

    @Override
    public int getItemCount() {

        return mDataFiltered.size();

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mDataFiltered = mData;
                } else {
                    List<ResponseDetail> filteredList = new ArrayList<>();
                    for (ResponseDetail row : mData) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getP().getProductName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    mDataFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mDataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mDataFiltered = (ArrayList<ResponseDetail>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_name, txt_price, txt_offer;
        Button btn_add_to_cart;
        ImageView imageView;
        NiceSpinner niceSpinner;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_item_name);
            imageView = itemView.findViewById(R.id.img_detail);
            txt_price = itemView.findViewById(R.id.txt_detail_amount);
            txt_offer = itemView.findViewById(R.id.txt_offer);
            niceSpinner = itemView.findViewById(R.id.spinner);
            btn_add_to_cart = itemView.findViewById(R.id.btn_addToCart);
            btn_add_to_cart.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if(view==btn_add_to_cart)
            {
                final ResponseDetail datum = mDataFiltered.get(getAdapterPosition());
                mOnClickListener.onListItemClick(datum,price);

            }

        }
    }
}
