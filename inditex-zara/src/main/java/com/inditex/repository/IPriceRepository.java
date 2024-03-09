package com.inditex.repository;

import com.inditex.model.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE " +
            "(:brandId IS NULL OR p.brand.id = :brandId) " +
            "AND (:productId IS NULL OR p.productId = :productId) " +
            "AND (:appDate IS NULL OR :appDate BETWEEN p.startDate AND p.endDate) " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findPricesByBrandIdAndProductIdAndDateRange(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("appDate") LocalDateTime appDate);


}
