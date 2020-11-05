package com.sas.tossabill.controller;

import com.sas.tossabill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public String getBills(){
        return "Hello World";
    }
}
