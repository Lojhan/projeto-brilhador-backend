package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientRelationship.clientRelationshipProject.models.Investment;
import com.clientRelationship.clientRelationshipProject.models.ProjectInfo;
import com.clientRelationship.clientRelationshipProject.repositories.InvestmentRepository;

@Service
public class CreateInvestmentService {
    
    @Autowired GetProjectInfoById getProjectInfoById;
    @Autowired InvestmentRepository investmentRepository;


    public Investment createInvestment(String projectId, String userId, Double investmentValue) {
        ProjectInfo projectInfo = getProjectInfoById.getProjectInfoById(projectId);
        Investment investment = new Investment();
        investment.setProjectId(projectId);
        investment.setUserId(userId);
        investment.setInvestmentValue(investmentValue);
        investment.setProjectName(projectInfo.getName());
        investment.setProjectDescription(projectInfo.getDescription());
        investment.setProjectDaysToDelivery(projectInfo.getDaysToDelivery());
        investmentRepository.save(investment);
        return investment;
    }
}
