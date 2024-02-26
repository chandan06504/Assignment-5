package com.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employees")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeMap;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeMap.get(id);
    }

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return "Employee added successfully";
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        if (employeeMap.containsKey(id)) {
            employeeMap.put(id, employee);
            return "Employee updated successfully";
        }
        return "Employee not found";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }
}
