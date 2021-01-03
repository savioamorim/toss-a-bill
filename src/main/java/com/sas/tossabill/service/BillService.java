package com.sas.tossabill.service;

import com.sas.tossabill.model.Bill;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface BillService {

    List<Bill> findAll();

    Bill findById(UUID id);

    Bill save(Bill bill);

    Bill update(Bill bill);

    void deleteById(UUID id);

    Bill updateArchive(UUID id, Boolean value);

    List<Bill> findAllByCategory(@Param("category") String category);

    List<Bill> findBillsByYearAndCategory(@Param("year") String year, @Param("category") String category);

    List<Bill> findBillsByMonthAndYear(@Param("month") String month, @Param("year") String year);

    List<Bill> findBillsByMonthAndYearAndCategory(@Param("month") String month, @Param("year") String year, @Param("category") String category);

    List<Bill> findAllByArchived(@Param("archived") Boolean archived);

    BigDecimal sumBillsByYear(@Param("year") String year);
}
