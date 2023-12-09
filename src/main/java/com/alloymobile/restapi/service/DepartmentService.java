package com.alloymobile.restapi.service;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(Long id) {
        return repository.findById(id).get();
    }

    public Department add(Department department) {
        return repository.save(department);
    }

    public Department update(Long id, Department department) {
        Optional<Department> dept = repository.findById(id);
        if(dept.isPresent()) {
            dept.get().setName(department.getName());
            return repository.save(dept.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
