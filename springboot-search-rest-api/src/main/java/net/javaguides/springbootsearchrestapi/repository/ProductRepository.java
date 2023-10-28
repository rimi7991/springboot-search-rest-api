package net.javaguides.springbootsearchrestapi.repository;

import net.javaguides.springbootsearchrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //JPQL Query
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :query, '%') OR p.description LIKE CONCAT('%', :query, '%')")

    List<Product> searchProducts(String query);

    //Native SQL query
    @Query(value = "SELECT * FROM products p WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            "OR p.description LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
