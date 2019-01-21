package infinity1087.android.com.examplehr.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation.RoundedTransformation;
import infinity1087.android.com.examplehr.model.BannerTrial;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyVIewHolder> {

    List<BannerTrial> mList;
    public RecyclerAdapter(List<BannerTrial> list) {

        mList = list;

    }

    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new MyVIewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder myVIewHolder, int i) {

        BannerTrial pojo = mList.get(i);

        Picasso.get().load("http://image.barodaweb.net/api/EGreen/Magic/800/Banner/" + pojo.getImageUrl() + "/80")
                .error(R.drawable.ic_launcher_background).placeholder(R.drawable.img1)
                .transform(new RoundedTransformation(20, 0)).fit()
                .into(myVIewHolder.img);

        Log.d("nan", pojo.getImageUrl());
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class MyVIewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public MyVIewHolder(@NonNull View itemView) {

            super(itemView);
//            txt = itemView.findViewById();
            img = itemView.findViewById(R.id.img_offer);
            itemView.getAnimation();

        }
    }
}
