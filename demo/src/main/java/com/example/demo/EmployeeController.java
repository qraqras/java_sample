package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(@ModelAttribute Employee employee) {
        return "index";
    }

    @PostMapping(value = "/", params = "search")
    public String search(Model model, @ModelAttribute Employee employee) {
        service.searchEmployees(employee.getName());
        Iterable<Employee> employees = service.searchEmployees(employee.getName());
        model.addAttribute("employees", employees);
        return "index";
    }

    @PostMapping(value = "/", params = "register")
    public String register(Model model, @ModelAttribute @Validated Employee employee,
            BindingResult result) {
        if (!result.hasErrors()) {
            service.registerEmployee(employee.getName());
        }
        Iterable<Employee> employees = service.searchEmployees(employee.getName());
        model.addAttribute("employees", employees);
        return "index";
    }

    @PostMapping(value = "/", params = "delete")
    public String delete(Model model, @Param("id") String id, @Param("name") String name) {
        service.deleteEmployee(Long.parseLong(id));
        Iterable<Employee> employees = service.searchEmployees(name);
        model.addAttribute("employee", new Employee(name));
        model.addAttribute("employees", employees);
        return "index";
    }

}
