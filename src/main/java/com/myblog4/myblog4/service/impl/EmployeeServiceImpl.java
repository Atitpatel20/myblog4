package com.myblog4.myblog4.service.impl;

import com.myblog4.myblog4.entity.Employee;
import com.myblog4.myblog4.payload.EmployeeDto;
import com.myblog4.myblog4.repository.EmployeeRepository;
import com.myblog4.myblog4.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmpRecord(EmployeeDto employeeDto) {
        Employee employees= new Employee();

        employees.setName(employeeDto.getName());
        employees.setDesignation(employeeDto.getDesignation());
        employees.setStudies(employeeDto.getStudies());
        employees.setExperience(employeeDto.getExperience());

        Employee saveEmpDetailes = employeeRepository.save(employees);
        EmployeeDto dto = new EmployeeDto();
        dto.setName(saveEmpDetailes.getName());
        dto.setDesignation(saveEmpDetailes.getDesignation());
        dto.setStudies(saveEmpDetailes.getStudies());
        dto.setExperience(saveEmpDetailes.getExperience());
        return dto;
    }
}