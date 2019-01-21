package infinity1087.android.com.examplehr.Roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import infinity1087.android.com.examplehr.ProductDetailModel.Pz;

@Dao
public interface DatabDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pz result);

//    @Query("SELECT * FROM movie_table")
//    LiveData<List<Pz>> getProductName();
//
//    @Query("SELECT * FROM movie_table")
//    LiveData<List<Pz>> getOfferText() ;
    @Query("SELECT * from movie_table ORDER BY productName ASC")
    List<Pz> getAllname();

    @Query("SELECT * from movie_table ORDER BY offerText ASC")
    List<Pz> getAllOfferprice();

}
