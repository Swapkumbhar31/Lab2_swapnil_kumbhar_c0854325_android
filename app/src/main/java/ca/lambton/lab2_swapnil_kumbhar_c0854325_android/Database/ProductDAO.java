package ca.lambton.lab2_swapnil_kumbhar_c0854325_android.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("select * from product")
    List<Product> getAllProducts();

    @Insert
    void addProduct(Product product);

    @Query("Delete from product where id=:id")
    void deleteProductById(int id);

    @Query("select * from product where name like '%' || :name || '%'")
    List<Product> searchProductByName(String name);

    @Query("select * from product where description like :description")
    List<Product> searchProductByDescription(String description);

    @Update
    void updateProduct(Product product);

    @Query("select * from product limit 1 offset :index")
    Product getProductByIndex(int index);

    @Query("select count(*) as count from product")
    int getProductsCount();

    @Query("Select * from product where id = :id")
    Product getProductById(int id);
}
