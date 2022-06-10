package com.clientRelationship.clientRelationshipProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientRelationship.clientRelationshipProject.models.ProjectInfo;

@Service
public class GetProjectInfoById {
    
    private RestTemplate restTemplate;

    GetProjectInfoById(
        RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    public ProjectInfo getProjectInfoById(String id) {
        ProjectInfo projectInfo = restTemplate.getForObject("http://strategic-systems-services-brilhador/projects/" + id, ProjectInfo.class);
        return projectInfo;
    }
}
