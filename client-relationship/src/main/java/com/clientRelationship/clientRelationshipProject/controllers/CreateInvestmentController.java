package com.clientRelationship.clientRelationshipProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientRelationship.clientRelationshipProject.models.Investment;
import com.clientRelationship.clientRelationshipProject.models.dto.CreateInvestmentDTO;
import com.clientRelationship.clientRelationshipProject.models.dto.UserResponse;
import com.clientRelationship.clientRelationshipProject.services.CreateInvestmentService;

@RestController @RequestMapping("create-investment") public class CreateInvestmentController {
    
    @Autowired private CreateInvestmentService createInvestmentService;
    
    @RequestMapping("") public ResponseEntity<Investment> createInvestment(
        CreateInvestmentDTO createInvestmentDTO,
        @RequestAttribute("user") UserResponse user
    ) {
        try {
            Investment investment = createInvestmentService.createInvestment(
                createInvestmentDTO.getProjectId(),
                user.getId().toString(),
                createInvestmentDTO.getInvestmentValue()
            );
            return ResponseEntity.ok(investment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
       
    }
}
