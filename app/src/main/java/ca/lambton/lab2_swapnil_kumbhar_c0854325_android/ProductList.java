package ca.lambton.lab2_swapnil_kumbhar_c0854325_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

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

        SearchView searchView = findViewById(R.id.search_bar_text);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String query = searchView.getQuery().toString();
                if (query.isEmpty()) {
                    System.out.println("query is empty");
                    products = productRoomDB.productDAO().getAllProducts();
                } else {
                    System.out.println("query : " + query);
                    products = productRoomDB.productDAO().searchProductByName(query);
                    System.out.println("query return count : " + products.size());
                }
                productListView.setAdapter(new ProductAdaptor(getApplicationContext(), products));
                return false;
            }
        });
    }
}