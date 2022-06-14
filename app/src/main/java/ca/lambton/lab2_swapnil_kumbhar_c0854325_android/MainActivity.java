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
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.Product;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductDAO;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database.ProductRoomDB;
import ca.lambton.lab2_swapnil_kumbhar_c0854325_android.SharedPreferences.UserSettings;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductRoomDB productRoomDB;
    private Button nextBtn;
    private Button previousBtn;
    private TextView txtProductId;
    private TextView txtProductName;
    private TextView txtProductDescription;
    private Product currentProduct;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        txtProductId = findViewById(R.id.txtProductId);
        txtProductName = findViewById(R.id.txtProductName);
        txtProductDescription = findViewById(R.id.txtProductDescription);

        nextBtn.setOnClickListener(this);


        setTitle("Product");

        productRoomDB = ProductRoomDB.getInstance(this);

        productRoomDB.productDAO().getAllProducts();

        UserSettings userSettings = new UserSettings().getInstance(getApplicationContext());
        boolean firstTimeOpen = new UserSettings().getInstance(getApplicationContext()).isFirstTimeOpen();
        
        if (firstTimeOpen) {
            insertProducts();
            userSettings.setIsFirstTimeOpen(false);
        }
        if (this.index > -1) {
            setProduct(this.index);
        }
    }

    private void insertProducts() {
        productRoomDB.productDAO().addProduct(new Product("iPhone 13 Pro", "Explore endless possibilities with the iPhone 13 Pro. It features the powerful A15 Bionic chip, superfast 5G to download and stream high-quality video, a bright 6.1\" Super Retina XDR display with ProMotion, and Ceramic Shield for better drop performance. Other features include Pro camera system with new 12MP Telephoto, Wide and Ultra Wide cameras, extra-ordinary battery life, and much more.", 1399.99));
        productRoomDB.productDAO().addProduct(new Product("iPad 10.2\" 64GB with Wi-Fi", "The Apple iPad combines a beautiful 10.2-inch Retina display and tremendous capability with unmatched versatility and ease of use. And with the powerful A13 Bionic chip, an Ultra Wide front camera with Center Stage, support for Apple Pencil, and the amazing new things you can do with iPadOS 15, there’s even more to love about this iPad.", 429.99));
        productRoomDB.productDAO().addProduct(new Product("MacBook Pro 13.3\"", "The Apple M1 chip redefines the 13\" MacBook Pro. Featuring an 8-core CPU that flies through complex workflows. Incredible 8-core GPU that crushes graphics-intensive tasks and enables super-smooth gaming. An advanced 16-core Neural Engine for more machine learning power. Super-fast unified memory for fluid performance. And the longest-ever battery life in a Mac at up to 20 hours.", 1699.99));
        productRoomDB.productDAO().addProduct(new Product("MacBook Air 13.3\" ", "Apple’s thinnest and lightest notebook gets supercharged with the Apple M1 chip. Tackle your projects with the blazing-fast 8-core CPU. Take graphics-intensive apps and games to the next level with a 7-core GPU. Accelerate machine-learning tasks with the 16-core Neural Engine. All with a silent, fanless design and the longest battery life ever -- up to 18 hours.", 1147.90));
        productRoomDB.productDAO().addProduct(new Product("MacBook Pro 16\"", "The most powerful MacBook Pro ever is here. With the blazing-fast M1 Pro or M1 Max chip — the first Apple silicon designed for pros — you get groundbreaking performance and amazing battery life. Add to that a stunning Liquid Retina XDR display, the best camera and audio ever in a Mac notebook, and all the ports you need. The first notebook of its kind, this MacBook Pro is a beast.", 2499.90));
        productRoomDB.productDAO().addProduct(new Product("iPad Air", "The breakthrough M1 chip is now in iPad Air. An 8-core CPU delivers up to 60 percent faster performance than the previous generation, making iPad Air a creative and mobile gaming powerhouse. Multitask smoothly between powerful apps and play graphics-intensive games. And with M1, you can go even further with your creativity with apps like SketchUp.", 749.00));
        productRoomDB.productDAO().addProduct(new Product("Apple Watch Series 7", "Apple Watch can do what your other devices can’t because it’s on your wrist. When you wear it, you get a fitness partner that measures all the ways you move, meaningful health insights, and a connection to the people and things you care about most. And it’s always just a glance away.", 569.0));
        productRoomDB.productDAO().addProduct(new Product("AirPods Pro", "Active Noise Cancellation blocks outside noise, so you can immerse yourself in music\n" +
                "Transparency mode for hearing and interacting with the world around you\n" +
                "Spatial audio with dynamic head tracking places sound all around you\n" +
                "Adaptive EQ automatically tunes music to your ears\n" +
                "Three sizes of soft, tapered silicone tips for a customizable fit\n" +
                "Force sensor lets you easily control your entertainment, answer or end calls, and more\n" +
                "Sweat and water resistant\n" +
                "More than 24 hours total listening time with the MagSafe Charging Case\n" +
                "Quick access to Siri by saying “Hey Siri”", 279.0));
        productRoomDB.productDAO().addProduct(new Product("AirPods Max", "Apple-designed dynamic driver provides high-fidelity audio\n" +
                "Active Noise Cancellation blocks outside noise, so you can immerse yourself in music\n" +
                "Transparency mode for hearing and interacting with the world around you\n" +
                "Spatial audio with dynamic head tracking provides theater-like sound that surrounds you\n" +
                "Computational audio combines custom acoustic design with the Apple H1 chip and software for breakthrough listening experiences\n" +
                "Designed with a knit-mesh canopy and memory foam ear cushions for an exceptional fit\n" +
                "Magical experience with effortless setup, on-head detection, and seamless switching between devices\n" +
                "Easily share audio between two sets of AirPods on your iPhone, iPad, iPod touch, or Apple TV\n" +
                "20 hours of listening, movie watching, or talk time with Active Noise Cancellation and spatial audio enabled\n" +
                "Store in ultra low-power mode with the slim Smart Case", 779.0));
        productRoomDB.productDAO().addProduct(new Product("Magic Keyboard with Touch ID and Numeric Keypad", "Magic Keyboard is available with Touch ID, providing fast, easy and secure authentication for logins and purchases.\n" +
                "\n" +
                "Magic Keyboard with Touch ID and Numeric Keypad delivers a remarkably comfortable and precise typing experience. It features an extended layout, with document navigation controls for quick scrolling and full-size arrow keys, which are great for gaming. The numeric keypad is also ideal for spreadsheets and finance applications. It’s wireless and features a rechargeable battery that will power your keyboard for about a month or more between charges.¹ It pairs automatically with your Mac, so you can get to work straightaway. And it includes a woven USB-C to Lightning Cable that lets you pair and charge by connecting to a USB-C port on your Mac.", 229.0));
        productRoomDB.productDAO().addProduct(new Product("Magic Mouse", "\n" +
                "Magic Mouse is wireless and rechargeable, with an optimised foot design that lets it glide smoothly across your desk. The Multi-Touch surface allows you to perform simple gestures such as swiping between web pages and scrolling through documents.\n" +
                "\n" +
                "The rechargeable battery will power your Magic Mouse for about a month or more between charges. It’s ready to go straight out of the box and pairs automatically with your Mac, and it includes a woven USB-C to Lightning Cable that lets you pair and charge by connecting to a USB-C port on your Mac.", 119.0));
    }

    private void setProduct(int index) {
        this.index = index;
        currentProduct = productRoomDB.productDAO().getProductByIndex(index);

        previousBtn.setEnabled(index != 0);

        txtProductId.setText("#" + currentProduct.getId());
        txtProductName.setText(currentProduct.getName());
        txtProductDescription.setText(currentProduct.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.goto_list) {
            System.out.println(menuItem.getItemId());
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                setProduct(this.index + 1);
                break;
            case R.id.previousBtn:
                setProduct(this.index - 1);
                break;
            default:;
        }
    }
}