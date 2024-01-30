package com.myblog4.myblog4.service.impl;

import com.myblog4.myblog4.entity.Employee;
import com.myblog4.myblog4.exception.ResourceNotFoundException;
import com.myblog4.myblog4.payload.EmployeeDto;
import com.myblog4.myblog4.repository.EmployeeRepository;
import com.myblog4.myblog4.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
        this.modelMapper=modelMapper;
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
    public List<EmployeeDto> getALlEmployee(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo,pageSize, sort);
        Page<Employee> pageEmployees = employeeRepository.findAll(pageable);
        List<Employee> employees = pageEmployees.getContent();
        List<EmployeeDto> dtos = employees.stream().map(emp -> mapToDto(emp)).collect(Collectors.toList());
        return dtos;
    }

    EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
//        EmployeeDto dto = new EmployeeDto();
//        dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        dto.setStudies(employee.getStudies());
//        dto.setDesignation(employee.getDesignation());
//        dto.setExperience(employee.getExperience());
        return dto;
    }

    Employee mapToEntity(EmployeeDto postDto) {
        Employee employee = modelMapper.map(postDto, Employee.class);
//        Employee employee = new Employee();
//        employee.setId(postDto.getId());
//        employee.setName(postDto.getName());
//        employee.setStudies(postDto.getStudies());
//        employee.setDesignation(postDto.getDesignation());
//        employee.setExperience(postDto.getExperience());
        return employee;
    }
}
