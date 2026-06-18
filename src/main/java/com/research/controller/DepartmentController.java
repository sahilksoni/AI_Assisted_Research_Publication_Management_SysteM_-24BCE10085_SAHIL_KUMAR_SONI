package com.research.controller;

import jakarta.validation.Valid;
import com.research.model.Department;
import com.research.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public Department createDepartment(
            @Valid @RequestBody Department department) {

        return service.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(
            @PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(
            @PathVariable String id,
            @RequestBody Department department) {

        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable String id) {

        service.delete(id);
        return "Department Deleted Successfully";
    }
}