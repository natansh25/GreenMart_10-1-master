package infinity1087.android.com.examplehr;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
        setContentView(R.layout.activity_cart_trail);
        mDb = AppDatabase.getDatabase(getApplicationContext());
        mRecyclerView = findViewById(R.id.recycler_view_cart);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mRoomModels = mDb.movieDao().getAllname();
                Log.d("carty", String.valueOf(mRoomModels.get(0)));
                setUpRecyclerVIew(mRoomModels);


            }
        });
        swipeToDelete();

        //TODO
        //first add some data then click on the cart on main page
        // just one small error the a will stop workin and improve th layout
        //cart is not made clickabe in detailview so do that passs Mycart intent on detailactivity also




    }

    private void swipeToDelete() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        RoomModel position = (RoomModel) viewHolder.itemView.getTag();

                        mDb.movieDao().delete(position);
                        
                     //   mCart.notifyDataSetChanged();

                    }
                });
            }
        }).attachToRecyclerView(mRecyclerView);
    }

    private void setUpRecyclerVIew(List<RoomModel> roomModels) {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        mCart = new RecyclerCart(roomModels);
        mRecyclerView.setAdapter(mCart);


    }
}
