package com.myblog4.myblog4.service.impl;

import com.myblog4.myblog4.entity.Employee;
import com.myblog4.myblog4.entity.Project;
import com.myblog4.myblog4.exception.ResourceNotFoundException;
import com.myblog4.myblog4.payload.ProjectDto;
import com.myblog4.myblog4.repository.EmployeeRepository;
import com.myblog4.myblog4.repository.ProjectRepositoty;
import com.myblog4.myblog4.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private EmployeeRepository employeeRepository;
    private ProjectRepositoty projectRepositoty;

    public ProjectServiceImpl(EmployeeRepository employeeRepository, ProjectRepositoty projectRepositoty) {
        this.employeeRepository = employeeRepository;
        this.projectRepositoty = projectRepositoty;
    }

    @Override
    public ProjectDto createProjects(ProjectDto projectDto, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Project not found with id:" + employeeId)
        );
        Project project= new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setEmail(projectDto.getEmail());
        project.setEmployee(employee);
        Project saveProjects = projectRepositoty.save(project);
        ProjectDto dto= new ProjectDto();
        dto.setId(saveProjects.getId());
        dto.setProjectName(saveProjects.getProjectName());
        dto.setEmail(saveProjects.getEmail());
        return dto;
    }
}
