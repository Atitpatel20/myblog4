package com.myblog4.myblog4.repository;

import com.myblog4.myblog4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
