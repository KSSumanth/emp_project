package sumanth.employee.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumanth.employee.emp.model.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Custom query method to search employees by department (case-insensitive)
    List<Employee> findByDepartmentContainingIgnoreCase(String department);

    List<Employee> findByNameContainingIgnoreCase(String name);
     List<Employee> findByJobTitleContainingIgnoreCase(String jobTitle);
    
    // You can add more custom methods here as needed
}

