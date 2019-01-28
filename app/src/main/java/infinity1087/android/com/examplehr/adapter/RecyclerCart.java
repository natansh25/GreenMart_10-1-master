package infinity1087.android.com.examplehr.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import infinity1087.android.com.examplehr.ProductDetailModel.RoomModel;
import infinity1087.android.com.examplehr.R;

public class RecyclerCart extends RecyclerView.Adapter<RecyclerCart.MyViewHolder> {
    private List<RoomModel> mRoomModels;

    public RecyclerCart(List<RoomModel> roomModels) {
        mRoomModels = roomModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_activity_cart_trial, viewGroup, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        RoomModel roomModel = mRoomModels.get(i);
        myViewHolder.txt_name.setText(roomModel.getName());
        myViewHolder.txt_weight.setText(roomModel.getPrice());
        Picasso.get().load(roomModel.getImage()).error(R.drawable.ic_launcher_background).fit().into(myViewHolder.img);
        Log.d("tagu",roomModel.getImage());
        myViewHolder.itemView.setTag(roomModel);

    }

    @Override
    public int getItemCount() {
        return mRoomModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name,txt_weight;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name=itemView.findViewById(R.id.list_cart_name);
            txt_weight=itemView.findViewById(R.id.list_cart_price);
            img=itemView.findViewById(R.id.list_cart_img);
        }
    }
}
