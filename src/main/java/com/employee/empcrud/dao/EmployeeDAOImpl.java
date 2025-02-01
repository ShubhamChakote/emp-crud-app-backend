package com.employee.empcrud.dao;

import com.employee.empcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager;

    public EmployeeDAOImpl(){

    }

    // inject entity manager using constructor injection

    @Autowired // autowired is optional if u have only one constructor (using here for good practice)
    public EmployeeDAOImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee emp =  entityManager.find(Employee.class,id);

        if (emp == null){
            throw new RuntimeException("Employee not found for id "+id);
        }

        return emp;
    }

    @Override
    public Employee save(Employee emp) {
        return entityManager.merge(emp);
    }

    @Override
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class,id);
        entityManager.remove(emp);
    }
}
