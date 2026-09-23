package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
//Update employee CRUD
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
