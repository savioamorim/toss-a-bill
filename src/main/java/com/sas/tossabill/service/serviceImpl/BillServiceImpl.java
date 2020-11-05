package com.sas.tossabill.service.serviceImpl;

import com.sas.tossabill.model.Bill;
import com.sas.tossabill.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements BillService {


    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Bill findById(UUID id) {
        return null;
    }
}
