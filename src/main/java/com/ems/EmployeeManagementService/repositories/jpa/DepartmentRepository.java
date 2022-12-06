package com.ems.EmployeeManagementService.repositories.jpa;


import com.ems.EmployeeManagementService.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Override
    List<Department> findAll();

    @Override
    <S extends Department> S save(S entity);

    @Override
    Optional<Department> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
