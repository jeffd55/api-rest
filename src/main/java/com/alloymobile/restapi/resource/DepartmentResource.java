package com.alloymobile.restapi.resource;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResource {

    DepartmentService service;

    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/departments")
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/departments", consumes = "application/json")
    public Department add(@RequestBody Department department) {
        return service.add(department);
    }

    @PutMapping(value = "/departments/{id}",consumes = "application/json")
    public Department update(@PathVariable("id") Long id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
