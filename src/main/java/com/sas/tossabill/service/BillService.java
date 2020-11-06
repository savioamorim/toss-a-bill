package com.sas.tossabill.service;

import com.sas.tossabill.model.Bill;

import java.util.List;
import java.util.UUID;

public interface BillService {

    List<Bill> findAll();

    Bill findById(UUID id);

    Bill save(Bill bill);

    Bill update(Bill bill);

    void deleteById(UUID id);

    Bill updateArchive(UUID id, Boolean value);

}
