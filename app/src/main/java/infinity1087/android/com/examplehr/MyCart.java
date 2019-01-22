package infinity1087.android.com.examplehr;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import infinity1087.android.com.examplehr.ProductDetailModel.RoomModel;
import infinity1087.android.com.examplehr.Roomdatabase.AppDatabase;
import infinity1087.android.com.examplehr.appExecuter.AppExecutors;

public class MyCart extends AppCompatActivity {

    private AppDatabase mDb;
    List<RoomModel> mRoomModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        mDb = AppDatabase.getDatabase(getApplicationContext());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mRoomModels=mDb.movieDao().getAllname();
                Log.d("carty", String.valueOf(mRoomModels.get(0)));

            }
        });




    }
}
