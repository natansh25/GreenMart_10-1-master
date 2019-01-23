package infinity1087.android.com.examplehr;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import infinity1087.android.com.examplehr.ProductDetailModel.RoomModel;
import infinity1087.android.com.examplehr.Roomdatabase.AppDatabase;
import infinity1087.android.com.examplehr.adapter.RecyclerCart;
import infinity1087.android.com.examplehr.appExecuter.AppExecutors;

import static android.widget.LinearLayout.HORIZONTAL;

public class MyCart extends AppCompatActivity {

    private AppDatabase mDb;
    List<RoomModel> mRoomModels;
    RecyclerView mRecyclerView;
    RecyclerCart mCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        mDb = AppDatabase.getDatabase(getApplicationContext());
        mRecyclerView = findViewById(R.id.recycler_view_cart);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mRoomModels = mDb.movieDao().getAllname();
                Log.d("carty", String.valueOf(mRoomModels.get(0)));

            }
        });
        //TODO
        //first add some data then click on the cart on main page
        // just one small error the a will stop workin and improve th layout
        //cart is not made clickabe in detailview so do that passs Mycart intent on detailactivity also


        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(manager);

        mCart = new RecyclerCart(mRoomModels);
        mRecyclerView.setAdapter(mCart);


    }
}
