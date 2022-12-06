package com.ems.EmployeeManagementService.controllers;


import com.ems.EmployeeManagementService.controllers.searchcriteria.EmployeeFilter;
import com.ems.EmployeeManagementService.entites.Department;
import com.ems.EmployeeManagementService.service.DepartmentService;
import com.ems.EmployeeManagementService.service.dtos.DepartmentDTO;
import com.ems.EmployeeManagementService.service.dtos.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/departments")
    @PreAuthorize("hasRole('DEPARTMENT')")
    public ResponseEntity<DepartmentDTO> create(@RequestBody @Valid DepartmentDTO departmentDTO){
        DepartmentDTO d = departmentService.save(departmentDTO);
        return ResponseEntity.ok(d);
    }


    @PutMapping("/departments")
    @PreAuthorize("hasRole('DEPARTMENT')")
    public ResponseEntity<DepartmentDTO> update(@RequestBody @Valid DepartmentDTO departmentDTO){
        DepartmentDTO d = departmentService.update(departmentDTO);
        return ResponseEntity.ok(d);
    }



    @GetMapping("/departments/{id}")
    @PreAuthorize("hasRole('Department')")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id){
        DepartmentDTO departmentDTO= departmentService.findById(id);
        return ResponseEntity.ok(departmentDTO);
    }

    @GetMapping("/departments")
    @PreAuthorize("hasRole('DEPARTMENT')")
    public Page<DepartmentDTO> findAll( @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "3") int size){
        Page<DepartmentDTO> departmentDTOPage= departmentService.findAll(page, size);
        return departmentDTOPage;
    }


    @DeleteMapping("/departments/{id}")
    @PreAuthorize("hasRole('DEPARTMENT')")
    public void deleteById(@PathVariable Long id){
        departmentService.deleteById(id);
    }



    @GetMapping("/departments/page/search")
    @PreAuthorize("hasRole('DEPARTMENT')")
    public Page<Department> search( @RequestParam String query,@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size){
        Page<Department> departments= departmentService.search(query,page,size);
        return departments;
    }


    @GetMapping("/departments/search")
   @PreAuthorize("hasRole('DEPARTMENT')")
    public List<Department> search( @RequestParam String query){
        List<Department> departments= departmentService.search(query);
        return departments;
    }

}
