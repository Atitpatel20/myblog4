package com.myblog4.myblog4.service;


import com.myblog4.myblog4.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService{
    EmployeeDto createEmpRecord(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long id);

    List<EmployeeDto> getALlEmployee(int pageNo, int pageSize);
}
