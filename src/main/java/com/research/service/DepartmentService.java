package com.research.service;

import com.research.model.Department;
import com.research.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Department update(String id, Department department) {

        Department existing = repository.findById(id).orElse(null);

        if(existing != null){
            existing.setDepartmentName(department.getDepartmentName());
            existing.setDepartmentHead(department.getDepartmentHead());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}