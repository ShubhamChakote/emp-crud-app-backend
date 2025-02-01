package com.employee.empcrud.rest;

import com.employee.empcrud.dao.EmployeeDAO;
import com.employee.empcrud.dao.EmployeeDAOImpl;
import com.employee.empcrud.entity.Employee;
import com.employee.empcrud.service.EmpService;
import com.employee.empcrud.service.EmpServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmpRestController {

    private EmpService empService;

    public EmpRestController (EmpService theEmpService) {
        this.empService = theEmpService;

    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmp() {
        return empService.findAll() ;
    }

    @GetMapping("/employees/{empid}")
    public Employee findById(@PathVariable int empid){
        return empService.findById(empid);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        Employee dbEmp = empService.save(employee);

        return dbEmp;

        // pass the new emp through the postman

    }

    @PutMapping("/employees")
    Employee updateEmployee(@RequestBody Employee employee){
        Employee emp = empService.save(employee);
        return emp;
    }

    @DeleteMapping("/employees/{empid}")
    String deleteEmpById(@PathVariable int empid){
        Employee emp = empService.findById(empid);

        if(emp == null){
            throw new RuntimeException("Employee not found for id "+empid);
        }

        empService.deleteById(empid);

        return "Deleted employee id -"+empid;
    }






}
