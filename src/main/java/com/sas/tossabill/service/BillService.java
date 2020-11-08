package com.sas.tossabill.service;

import com.sas.tossabill.model.Bill;
import org.springframework.data.repository.query.Param;

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

}
