package ca.lambton.lab2_swapnil_kumbhar_c0854325_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Adaptor.ProductAdaptor;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.Product;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductRoomDB;

public class ProductList extends AppCompatActivity {

    private ProductRoomDB productRoomDB;
    List<Product> products;
    ListView productListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        setTitle("Products");

        productRoomDB = ProductRoomDB.getInstance(this);

        products = productRoomDB.productDAO().getAllProducts();

        productListView = findViewById(R.id.productListView);

        productListView.setAdapter(new ProductAdaptor(this, products));
    }
}