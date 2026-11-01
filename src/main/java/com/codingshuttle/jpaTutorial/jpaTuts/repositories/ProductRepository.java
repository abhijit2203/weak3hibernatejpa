package com.codingshuttle.jpaTutorial.jpaTuts.repositories;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByTitleLike(String s);

    List<ProductEntity> findByTitleContaining(String s);

    List<ProductEntity> findByTitleContainingIgnoreCase(String s);

    //Optional<ProductEntity>  findByTitleAndPrice(String title, BigDecimal price);

//    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e.title from ProductEntity e where e.title=:title and e.price=:price")
    Optional<String> findByTitleAndPrice(String title, BigDecimal price);
}
