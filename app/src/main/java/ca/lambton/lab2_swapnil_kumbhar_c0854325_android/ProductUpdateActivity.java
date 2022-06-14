package ca.lambton.lab2_swapnil_kumbhar_c0854325_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.Product;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductRoomDB;

public class ProductUpdateActivity extends AppCompatActivity {
    Product product;

    EditText editTextProductName;
    EditText editTextProductDescription;
    EditText editTextProductPrice;
    Button actionButton;

    private ProductRoomDB productRoomDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_update);

        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductDescription = findViewById(R.id.editTextProductDescription);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);
        actionButton = findViewById(R.id.actionBtn);

        productRoomDB = ProductRoomDB.getInstance(this);
        Intent intent = getIntent();
        int productId = intent.getIntExtra("product_id", -1);
        if (productId == -1) {
            setTitle("New Product");
            product = new Product("", "", null);
            actionButton.setText("Add Product");
        } else {
            setTitle("Update Product");
            product = productRoomDB.productDAO().getProductById(productId);
            actionButton.setText("Update Product");
        }

        editTextProductName.setText(product.getName());
        editTextProductDescription.setText(product.getDescription());
        if (product.getPrice() != null)
        {
            editTextProductPrice.setText(product.getPrice().toString());
        }

        actionButton.setOnClickListener(view -> {
            if (isValidProduct()) {

            }
        });

        editTextProductPrice.setOnKeyListener((view, i, keyEvent) -> {
            String str = editTextProductPrice.getText().toString();
            try {
                Double price = Double.valueOf(str);
                product.setPrice(price);
                editTextProductPrice.setError(null);
            } catch (Exception e) {
                editTextProductPrice.setError("Invalid price value");
            }
            checkRequiredError(editTextProductPrice, "Invalid price value");
            return false;
        });

        editTextProductName.setOnKeyListener((view, i, keyEvent) -> {
            checkRequiredError(editTextProductName, "Invalid name value");
            return false;
        });

        editTextProductDescription.setOnKeyListener((view, i, keyEvent) -> {
            checkRequiredError(editTextProductDescription, "Invalid description value");
            return false;
        });
    }

    private void checkRequiredError(EditText editText, String msg) {
        String str = editText.getText().toString();
        if (str.isEmpty()) {
            editText.setError(msg);
        } else {
            editText.setError(null);
        }
    }

    private boolean isValidProduct() {
        checkRequiredError(editTextProductPrice, "Invalid price value");
        checkRequiredError(editTextProductName, "Invalid name value");
        checkRequiredError(editTextProductDescription, "Invalid description value");
        if (editTextProductPrice.getError().length() > 0) {
            return false;
        }
        if (editTextProductName.getError().length() > 0) {
            return false;
        }
        if (editTextProductDescription.getError().length() > 0) {
            return false;
        }
        return true;
    }
}