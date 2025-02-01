package com.employee.empcrud.dao;

import com.employee.empcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee emp);

    void deleteById(int id);

}
