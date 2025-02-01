package com.employee.empcrud.service;

import com.employee.empcrud.dao.EmployeeDAO;
import com.employee.empcrud.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    private EmployeeDAO empdao;

    public EmpServiceImpl(EmployeeDAO theEmpdao){
        this.empdao = theEmpdao;
    }

    @Override
    public List<Employee> findAll() {
        return empdao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return empdao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee emp) {
        return empdao.save(emp);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        empdao.deleteById(id);
    }
}
