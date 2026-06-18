package com.research.repository;

import com.research.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository
        extends MongoRepository<Department, String> {
}