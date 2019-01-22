package infinity1087.android.com.examplehr.ProductDetailModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Grossary_table")
public class RoomModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ProductName")
    String name;
    @ColumnInfo(name = "ProductPrice")
    String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @ColumnInfo(name = "ProductImage")
    String image;

}
