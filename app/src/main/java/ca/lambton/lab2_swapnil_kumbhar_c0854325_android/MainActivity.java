package ca.lambton.lab2_swapnil_kumbhar_c0854325_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductDAO;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductRoomDB;

public class MainActivity extends AppCompatActivity {

    private ProductRoomDB productRoomDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Products");

        productRoomDB = ProductRoomDB.getInstance(this);

        productRoomDB.productDAO().getAllProducts();
    }
}