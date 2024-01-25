package com.myblog4.myblog4.controller;

import com.myblog4.myblog4.payload.ProjectDto;
import com.myblog4.myblog4.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    // http://localhost:8080/api/projects?employeeId=1

    @PostMapping
    public ResponseEntity<ProjectDto>createProjects(
            @RequestBody ProjectDto projectDto,
            @RequestParam long employeeId
    ){
        ProjectDto projects = projectService.createProjects(projectDto, employeeId);
        return new ResponseEntity<>(projects, HttpStatus.CREATED);
    }
}
