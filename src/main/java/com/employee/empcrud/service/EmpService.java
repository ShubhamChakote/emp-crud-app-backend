package com.employee.empcrud.service;

import com.employee.empcrud.entity.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee emp);

    void deleteById(int id);


}
