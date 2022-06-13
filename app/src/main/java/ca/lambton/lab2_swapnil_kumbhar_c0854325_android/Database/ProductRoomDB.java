package ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductRoomDB extends RoomDatabase {

    public static final String DATABASE_NAME = "product_db";

    public static volatile ProductRoomDB productRoomDB;

    public static ProductRoomDB getInstance(Context context) {
        if (productRoomDB == null) {
            productRoomDB = Room
                    .databaseBuilder(context, ProductRoomDB.class, DATABASE_NAME)
                    .build();
        }
        return productRoomDB;
    }

    public abstract ProductDAO productDAO();
}
