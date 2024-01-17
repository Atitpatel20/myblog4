package com.myblog4.myblog4.controller;

import com.myblog4.myblog4.payload.EmployeeDto;
import com.myblog4.myblog4.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/persnolize")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam long id){
        EmployeeDto dto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping
    public List<EmployeeDto> getALlEmployee(){
        List<EmployeeDto> employeeDtos=employeeService.getALlEmployee();
        return employeeDtos;
    }

}
