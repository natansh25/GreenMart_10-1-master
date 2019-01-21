package infinity1087.android.com.examplehr;

import android.app.Application;
        import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

        import infinity1087.android.com.examplehr.ProductDetailModel.Pz;
        import infinity1087.android.com.examplehr.Roomdatabase.AppDatabase;
        import infinity1087.android.com.examplehr.Roomdatabase.DatabDao;

public class Repository {

    private DatabDao mdatabDao;
    private LiveData<List<Pz>> mData;
    private LiveData<List<Pz>> mPrice;
    private LiveData<List<Pz>> mName;
    private int movie1ID;


    public Repository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        mdatabDao = db.movieDao();

    }

    public Repository(int movie1ID, Context context){

        AppDatabase db = AppDatabase.getDatabase(context);
        mdatabDao = db.movieDao();
        this.movie1ID = movie1ID;
//        RemoteNetworkCall.fetchMovieReview(movieID);
//        RemoteNetworkCall.fetchMovieTrailer(movieID);
    }
    public void insert(Pz result) {

        new insertAsyncTask(mdatabDao).execute(result);

    }

    private class insertAsyncTask extends AsyncTask<Pz, Void, Void> {

        public insertAsyncTask(DatabDao mdatabDao) {

        }

        public void execute(Pz result) {

        }

        @Override
        protected Void doInBackground(Pz... pzs) {
            return null;
        }
    }
}
