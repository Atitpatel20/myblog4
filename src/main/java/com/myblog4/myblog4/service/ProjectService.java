package com.myblog4.myblog4.service;

import com.myblog4.myblog4.payload.ProjectDto;

public interface ProjectService {
    ProjectDto createProjects(
             ProjectDto projectDto,long employeeId);

    void deleteProjectById(long id);

    ProjectDto updateProject(long id, ProjectDto projectDto, long employeeId);
}
