package com.unionistashop.crud_app_1.crud_app_2.controller;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.crud_app_2.services.EmployeeService2;
import com.unionistashop.crud_app_1.crud_app_2.entity.Employee2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employees2")
public class EmployeeController2 {
    private EmployeeService2 employeeService;
    @Autowired()
    public EmployeeController2(EmployeeService2 employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeController2() {
    }

    @GetMapping("list")
    public String listEmployees(Model model) {
// get the employees from db
        List<Employee2> employees = employeeService.list();
//        add to the spring model

        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("create")
    public String createEmployee(Model model) {
        Employee2 employee = new Employee2();
      model.addAttribute("employee", employee);


        return "create-employee";
    }

    @PostMapping()
    public String createEmployee(CreateEmployeeDto data, @ModelAttribute("employee") Employee2 employee) {
        this.employeeService.create(data);
        return "redirect:/employees2/list";
    }
}

