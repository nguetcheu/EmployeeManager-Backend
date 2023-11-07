package com.nguetcheu.EmployeeManager.repository;

import com.nguetcheu.EmployeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    // use Optional<Employee> for type of this methods because it's possible to return Exception(UserFoundException)
    Optional<Employee> findEmployeeById(Long id);
}
