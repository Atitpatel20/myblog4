package com.myblog4.myblog4.service.impl;

import com.myblog4.myblog4.entity.Employee;
import com.myblog4.myblog4.exception.ResourceNotFoundException;
import com.myblog4.myblog4.payload.EmployeeDto;
import com.myblog4.myblog4.repository.EmployeeRepository;
import com.myblog4.myblog4.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmpRecord(EmployeeDto employeeDto) {
        Employee employees = mapToEntity(employeeDto);

        Employee saveEmpDetailes = employeeRepository.save(employees);
        EmployeeDto dto = mapToDto(saveEmpDetailes);
        return dto;
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Record not found with id: " + id)
        );
        EmployeeDto dto = mapToDto(employee);
        return dto;
    }

    @Override
    public List<EmployeeDto> getALlEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dtos = employees.stream().map(emp -> mapToDto(emp)).collect(Collectors.toList());
        return dtos;
    }

    EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setStudies(employee.getStudies());
        dto.setDesignation(employee.getDesignation());
        dto.setExperience(employee.getExperience());
        return dto;
    }

    Employee mapToEntity(EmployeeDto postDto) {
        Employee employee = new Employee();
        employee.setId(postDto.getId());
        employee.setName(postDto.getName());
        employee.setStudies(postDto.getStudies());
        employee.setExperience(postDto.getExperience());
        employee.setExperience(postDto.getExperience());
        return employee;
    }
}
