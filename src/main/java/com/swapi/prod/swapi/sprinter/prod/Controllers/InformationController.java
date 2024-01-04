package com.swapi.prod.swapi.sprinter.prod.Controllers;

import com.swapi.prod.swapi.sprinter.prod.DataModels.InformationResponse;
import com.swapi.prod.swapi.sprinter.prod.Services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @GetMapping
    public InformationResponse getInformation(@RequestParam String attackingPersonName, @RequestParam String planetName){
        return informationService.getInformation(attackingPersonName, planetName);
    }
}
