package ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.Product;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.R;

public class ProductAdaptor extends BaseAdapter {

    Context context;
    List<Product> products;
    LayoutInflater inflater;

    public ProductAdaptor(Context applicationContext, List<Product> products) {
        this.context = applicationContext;
        this.products = products;
        inflater = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.product_list_view, null);
        TextView productName = view.findViewById(R.id.txtProductName);
        TextView productDescription = view.findViewById(R.id.txtProductDescription);
        productName.setText(products.get(i).getName());
        productDescription.setText(products.get(i).getDescription());
        return view;
    }
}
