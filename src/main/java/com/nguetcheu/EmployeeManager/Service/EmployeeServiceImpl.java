package com.nguetcheu.EmployeeManager.Service;

import com.nguetcheu.EmployeeManager.exception.UserFoundException;
import com.nguetcheu.EmployeeManager.model.Employee;
import com.nguetcheu.EmployeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE UUID before the storage of employee
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // use orElseThrow to generate UserFoundException if employee don't have valid id
    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow( () -> new UserFoundException("User by id " + id + " was not found "));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

}
