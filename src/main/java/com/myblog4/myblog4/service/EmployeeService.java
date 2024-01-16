package com.myblog4.myblog4.service;


import com.myblog4.myblog4.payload.EmployeeDto;

public interface EmployeeService{
    EmployeeDto createEmpRecord(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long id);
}
