package com.sas.tossabill.controller;

import com.sas.tossabill.model.Bill;
import com.sas.tossabill.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins="*")
@Api(value="API REST Bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Find all bills")
    public List<Bill> findAllBills(){
        return billService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Find a bill by id")
    public Bill findBill(@PathVariable UUID id){
        return billService.findById(id);
    }

    @PostMapping
    @ApiOperation(value="Create a bill")
    public Bill saveBill(@RequestBody Bill bill){
        return billService.save(bill);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete a bill")
    public void deleteBillById(@PathVariable UUID id){
        billService.deleteById(id);
    }

    @PutMapping
    @ApiOperation(value="Update all bills")
    public Bill updateBill(@RequestBody Bill bill){
        return billService.save(bill);
    }

    @PostMapping("/{id}/archive")
    @ApiOperation(value="Archive the specific bill")
    public Bill archiveBill(@PathVariable UUID id){
        return billService.updateArchive(id, true);
    }

    @PostMapping("/{id}/unarchive")
    @ApiOperation(value="Unarchive the specific bill")
    public Bill unarchiveBill(@PathVariable UUID id){
        return billService.updateArchive(id, false);
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find bills by category")
    public List<Bill> findAllByCategory(@PathVariable String category){
        return billService.findAllByCategory(category);
    }

    @GetMapping("/year-category/{year}-{category}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find bills by year and category")
    public List<Bill> findBillsByYearAndCategory(@PathVariable String year, @PathVariable String category){
        return billService.findBillsByYearAndCategory(year, category);
    }

    @GetMapping("/month-year/{month}-{year}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find bills by month and year")
    public List<Bill> findBillsByMonthAndYear(@PathVariable String month, @PathVariable String year){
        return billService.findBillsByMonthAndYear(month, year);
    }

    @GetMapping("/month-year-category/{month}-{year}-{category}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find bills by month, year and category")
    public List<Bill> findBillsByMonthAndYearAndCategory(@PathVariable String month, @PathVariable String year, @PathVariable String category){
        return billService.findBillsByMonthAndYearAndCategory(month, year, category);
    }

    @GetMapping("/archived/{archived}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find bills by archived")
    public List<Bill> findAllByArchived(@PathVariable Boolean archived){
        return billService.findAllByArchived(archived);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/totalValueByYear/{year}")
    @ApiOperation(value = "Return sum of the bills by year")
    public BigDecimal sumBillsByYear(@PathVariable String year){
        return billService.sumBillsByYear(year);
    }

}
