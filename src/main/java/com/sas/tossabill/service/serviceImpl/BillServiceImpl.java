package com.sas.tossabill.service.serviceImpl;

import com.sas.tossabill.model.Bill;
import com.sas.tossabill.repository.BillRepository;
import com.sas.tossabill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill findById(UUID id) {
        return billRepository.findById(id).get();
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill update(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void deleteById(UUID id) {
        billRepository.deleteById(id);
    }

    @Override
    public Bill updateArchive(UUID id, Boolean value) {
        Bill bill = findById(id);
        bill.setArchived(value);
        bill = save(bill);
        return bill;
    }

    @Override
    public List<Bill> findAllByCategory(String category) {
        return billRepository.findAllByCategory(category);
    }

    @Override
    public List<Bill> findBillsByYearAndCategory(String year, String category) {
        return billRepository.findBillsByYearAndCategory(year, category);
    }

    @Override
    public List<Bill> findBillsByMonthAndYear(String month, String year) {
        return billRepository.findBillsByMonthAndYear(month, year);
    }

    @Override
    public List<Bill> findBillsByMonthAndYearAndCategory(String month, String year, String category) {
        return billRepository.findBillsByMonthAndYearAndCategory(month, year, category);
    }

    @Override
    public List<Bill> findAllByArchived(Boolean archived) {
        return billRepository.findAllByArchived(archived);
    }

    @Override
    public BigDecimal sumBillsByYear(String year) {
        return billRepository.sumBillsByYear(year);
    }

}
