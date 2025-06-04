package sumanth.employee.emp.service;

import sumanth.employee.emp.model.Employee;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
     List<Employee> findByDepartment(String department);
}

