package com.myblog4.myblog4.service;

import com.myblog4.myblog4.payload.ProjectDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProjectService {
    ProjectDto createProjects(
             ProjectDto projectDto,long employeeId);

}
