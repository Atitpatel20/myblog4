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
    // http://locahost:8080/api/projects/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProjectById(@PathVariable long id){
        projectService.deleteProjectById(id);
        return new ResponseEntity<>("Record is deleted",HttpStatus.OK);
    }
    // http://localhost:8080/api/projects/1
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto>updateProject(@PathVariable long id,@RequestBody ProjectDto projectDto){
        ProjectDto dto=projectService.updateProject(id,projectDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
