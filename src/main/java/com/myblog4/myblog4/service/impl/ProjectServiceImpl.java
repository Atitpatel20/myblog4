package com.myblog4.myblog4.service.impl;

import com.myblog4.myblog4.entity.Employee;
import com.myblog4.myblog4.entity.Project;
import com.myblog4.myblog4.exception.ResourceNotFoundException;
import com.myblog4.myblog4.payload.ProjectDto;
import com.myblog4.myblog4.repository.EmployeeRepository;
import com.myblog4.myblog4.repository.ProjectRepositoty;
import com.myblog4.myblog4.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private EmployeeRepository employeeRepository;
    private ProjectRepositoty projectRepositoty;
    private ModelMapper modelMapper;

    public ProjectServiceImpl(EmployeeRepository employeeRepository, ProjectRepositoty projectRepositoty,ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.projectRepositoty = projectRepositoty;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProjectDto createProjects(ProjectDto projectDto, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Project not found with id:" + employeeId)
        );
        Project project = mapToEntity(projectDto);
//        Project project= new Project();
//        project.setProjectName(projectDto.getProjectName());
//        project.setEmail(projectDto.getEmail());
//        project.setEmployee(employee);
        Project saveProjects = projectRepositoty.save(project);

//        ProjectDto dto= new ProjectDto();
//        dto.setId(saveProjects.getId());
//        dto.setProjectName(saveProjects.getProjectName());
//        dto.setEmail(saveProjects.getEmail());
        return mapToDto(saveProjects);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepositoty.deleteById(id);
    }
    @Override
    public ProjectDto updateProject(long id, ProjectDto projectDto, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id:" + id)
        );
        Project project = projectRepositoty.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Project not found with id:" + id)
        );
        Project p = mapToEntity(projectDto);
//        project.setId(projectDto.getId());
//        project.setProjectName(projectDto.getProjectName());
//        project.setEmail(projectDto.getEmail());
//
        p.setId(project.getId());
        p.setEmployee(employee);
        Project update = projectRepositoty.save(p);
//        ProjectDto dto= new ProjectDto();
//        dto.setId(update.getId());
//        dto.setProjectName(update.getProjectName());
//        dto.setEmail(update.getEmail());
        return mapToDto(update);
    }
    ProjectDto mapToDto(Project project){
        ProjectDto dto = modelMapper.map(project, ProjectDto.class);
        return dto;
    }
    Project mapToEntity(ProjectDto projectDto){
        Project project = modelMapper.map(projectDto, Project.class);
        return project;
    }
}
