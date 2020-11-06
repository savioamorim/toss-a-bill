package com.sas.tossabill.controller;

import com.sas.tossabill.model.Bill;
import com.sas.tossabill.repository.BillRepository;
import com.sas.tossabill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bill> findAllBills(){
        return billService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bill findBill(@PathVariable UUID id){
        return billService.findById(id);
    }

    @PostMapping
    public Bill saveBill(@RequestBody Bill bill){
        return billService.save(bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBillById(@PathVariable UUID id){
        billService.deleteById(id);
    }

    @PutMapping
    public Bill updateBill(@RequestBody Bill bill){
        return billService.save(bill);
    }

    @PostMapping("/{id}/archive")
    public Bill archiveBill(@PathVariable UUID id){
        return billService.updateArchive(id, true);
    }

    @PostMapping("/{id}/unarchive")
    public Bill unarchiveBill(@PathVariable UUID id){
        return billService.updateArchive(id, false);
    }

}
