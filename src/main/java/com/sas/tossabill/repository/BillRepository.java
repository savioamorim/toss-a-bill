package com.sas.tossabill.repository;

import com.sas.tossabill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface BillRepository extends JpaRepository<Bill, UUID> {

    @Query("SELECT b FROM bill b WHERE b.archived = :archived")
    List<Bill> findAllByArchived(@Param("archived") Boolean archived);

    @Query("SELECT b FROM bill b WHERE b.category = :category")
    List<Bill> findAllByCategory(@Param("category") String category);

    @Query("SELECT b FROM bill b WHERE b.year = :year AND b.category = :category")
    List<Bill> findBillsByYearAndCategory(@Param("year") String year, @Param("category") String category);

    @Query("SELECT b FROM bill b WHERE b.month = :month AND b.year = :year")
    List<Bill> findBillsByMonthAndYear(@Param("month") String month, @Param("year") String year);

    @Query("SELECT b FROM bill b WHERE b.month = :month AND b.year = :year AND b.category = :category")
    List<Bill> findBillsByMonthAndYearAndCategory(@Param("month") String month, @Param("year") String year, @Param("category") String category);

    @Query("SELECT SUM(price) FROM bill b WHERE b.year = :year")
    BigDecimal sumBillsByYear(@Param("year") String year);
}
