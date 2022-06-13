package ca.lambton.lab2_swapnil_kumbhar_c0854325_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);

        MenuItem getItem = menu.findItem(R.id.goto_list);
        if (getItem != null) {
            AppCompatButton button = (AppCompatButton) getItem.getActionView();
            //Set a ClickListener, the text,
            //the background color or something like that
        }

        return super.onCreateOptionsMenu(menu);
    }
}