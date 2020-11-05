package com.sas.tossabill.service;

import com.sas.tossabill.model.Bill;

import java.util.List;
import java.util.UUID;

public interface BillService {

    List<Bill> findAll();
    Bill findById(UUID id);
}
