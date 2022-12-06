package com.ems.EmployeeManagementService.controllers;

import com.ems.EmployeeManagementService.controllers.searchcriteria.EmployeeFilter;
import com.ems.EmployeeManagementService.entites.Employee;
import com.ems.EmployeeManagementService.service.EmployeeService;
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
public class EmployeeController {
    
    private final EmployeeService employeeService;


    @PostMapping("/employees")
//    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<EmployeeDTO> create(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDTO d = employeeService.save(employeeDTO);
        return ResponseEntity.ok(d);
    }


    @PutMapping("/employees")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<EmployeeDTO> update(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDTO d = employeeService.save(employeeDTO);
        return ResponseEntity.ok(d);
    }



    @GetMapping("/employees/{id}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id){
        EmployeeDTO employeeDTO= employeeService.findById(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/employees")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public Page<EmployeeDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "3") int size){
        Page<EmployeeDTO> employeeDTOPage= employeeService.findAll(page, size);
        return employeeDTOPage;
    }

    @GetMapping("/employees/{department_id}/departments")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public List<EmployeeDTO> findAllByDepartmentId(@PathVariable Long department_id){
        List<EmployeeDTO> employeeDTOList= employeeService.findAllByDepartmentId(department_id);
        return employeeDTOList;
    }

    @GetMapping("/employees/search-by-elastic")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public List<EmployeeDTO> search(@RequestParam String query){
        List<EmployeeDTO> employeeDTOList= employeeService.search(query);
        return employeeDTOList;
    }


    @GetMapping("/employees/page/search-by-elastic")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public Page<EmployeeDTO> search(@RequestParam String query, @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "3") int size){
        Page<EmployeeDTO> employeeDTOList= employeeService.search(query,page,size);
        return employeeDTOList;
    }

    @PostMapping("/employees/search")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public Page<EmployeeDTO> findAllBySearchCriteria(@RequestBody EmployeeFilter employeeFilter,@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "3") int size){
        Page<EmployeeDTO> employeeDTOPage= employeeService.findAllBySearchCriteria(page, size, employeeFilter);
        return employeeDTOPage;
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }
}
