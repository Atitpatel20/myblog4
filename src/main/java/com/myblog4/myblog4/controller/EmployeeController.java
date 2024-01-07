package com.myblog4.myblog4.controller;

import com.myblog4.myblog4.payload.EmployeeDto;
import com.myblog4.myblog4.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto>createEmpRecord(@RequestBody EmployeeDto employeeDto){
        EmployeeDto empRecord = employeeService.createEmpRecord(employeeDto);
        return new ResponseEntity<>(empRecord, HttpStatus.CREATED);
    }
}
