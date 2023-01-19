package ua.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.DAO.EmployeeDAO;
import ua.ExceptionHandling.EmployeeIncorrectData;
import ua.ExceptionHandling.NoSuchEmployeeException;
import ua.entity.Employee;
import ua.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employees=service.getAllEmployees();
        return employees;

    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        service.saveEmployee(employee);
return  employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        service.saveEmployee(employee);
        return  employee;

    }
    @DeleteMapping("/employees/{id}")
    public  String deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);

        return "employee with id="+id+" was deleted";

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable int id){
        Employee employee=service.getEmployee(id);
        if (employee==null) {
            throw new NoSuchEmployeeException("there is no employee on id=" + id);
        }

        return employee;

    }



}
