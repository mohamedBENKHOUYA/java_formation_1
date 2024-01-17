package com.unionistashop.crud_app_1.rest;

import com.unionistashop.crud_app_1.DAOs.EmployeeDAO;
import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;
import com.unionistashop.crud_app_1.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees1")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public List<Employee> list() {
        return this.employeeService.list();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return this.employeeService.findOne(employeeId);
    }

    @PostMapping()
    public Employee create(@Valid CreateEmployeeDto data) {

        return this.employeeService.create(data);
    }

    @DeleteMapping("{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId) {
        return this.employeeService.delete(employeeId);
    }

    @PutMapping("{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody UpdateEmployeeDto data) {
        return this.employeeService.update(employeeId, data);
    }
}
