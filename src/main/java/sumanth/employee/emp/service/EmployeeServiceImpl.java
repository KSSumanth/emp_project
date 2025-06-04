// package sumanth.employee.emp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.repository.EmployeeRepository;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class EmployeeServiceImpl implements EmployeeService {

//     @Autowired
//     private EmployeeRepository employeeRepository;

//     @Override
//     public List<Employee> getAllEmployees() {
//         return employeeRepository.findAll();
//     }

//     @Override
//     public Optional<Employee> getEmployeeById(Long id) {
//         return employeeRepository.findById(id);
//     }

//     @Override
//     public Employee createEmployee(Employee employee) {
//         return employeeRepository.save(employee);
//     }

//     @Override
//     public Employee updateEmployee(Long id, Employee employee) {
//         // Basic update logic
//         Employee existing = employeeRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Employee not found"));

//         existing.setName(employee.getName());
//         existing.setDepartment(employee.getDepartment());
//         existing.setJobTitle(employee.getJobTitle());
//         existing.setEmail(employee.getEmail());
//         existing.setPhoneNumber(employee.getPhoneNumber());

//         return employeeRepository.save(existing);
//     }

//     @Override
//     public void deleteEmployee(Long id) {
//         employeeRepository.deleteById(id);
//     }   
// public List<Employee> findByDepartment(String department) {
//      if (department == null || department.trim().isEmpty()) {
//         throw new IllegalArgumentException("Department cannot be empty");
//     }
//     return employeeRepository.findByDepartmentContainingIgnoreCase(department);
// }
// }






// package sumanth.employee.emp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.validation.annotation.Validated;
// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.repository.EmployeeRepository;

// import jakarta.validation.Valid;
// import java.util.List;
// import java.util.Optional;

// @Service
// @Validated
// public class EmployeeServiceImpl implements EmployeeService {

//     @Autowired
//     private EmployeeRepository employeeRepository;

//     @Override
//     public List<Employee> getAllEmployees() {
//         return employeeRepository.findAll();
//     }

//     @Override
//     public Optional<Employee> getEmployeeById(Long id) {
//         return employeeRepository.findById(id);
//     }

//     @Override
//     public Employee createEmployee(@Valid Employee employee) {
//         return employeeRepository.save(employee);
//     }

//     @Override
//     public Employee updateEmployee(Long id, @Valid Employee employee) {
//         Employee existing = employeeRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Employee not found"));

//         existing.setName(employee.getName());
//         existing.setDepartment(employee.getDepartment());
//         existing.setJobTitle(employee.getJobTitle());
//         existing.setEmail(employee.getEmail());
//         existing.setPhoneNumber(employee.getPhoneNumber());
//         existing.setAddress(employee.getAddress());
//         existing.setJoiningDate(employee.getJoiningDate());
//         existing.setManagerName(employee.getManagerName());
//         existing.setProfilePictureUrl(employee.getProfilePictureUrl());

//         return employeeRepository.save(existing);
//     }

//     @Override
//     public void deleteEmployee(Long id) {
//         employeeRepository.deleteById(id);
//     }

//     @Override
//     public List<Employee> findByDepartment(String department) {
//         if (department == null || department.trim().isEmpty()) {
//             throw new IllegalArgumentException("Department cannot be empty");
//         }
//         return employeeRepository.findByDepartmentContainingIgnoreCase(department);
//     }
// }





package sumanth.employee.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumanth.employee.emp.model.Employee;
import sumanth.employee.emp.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        // Additional manual validation as backup
        if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is mandatory");
        }
        if (employee.getPhoneNumber() == null || employee.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number is mandatory");
        }
        return employeeRepository.save(employee);
    }

    // Keep all other methods unchanged
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setJobTitle(employee.getJobTitle());
        existing.setEmail(employee.getEmail());
        existing.setPhoneNumber(employee.getPhoneNumber());
        existing.setAddress(employee.getAddress());
        existing.setJoiningDate(employee.getJoiningDate());
        existing.setManagerName(employee.getManagerName());
        existing.setProfilePictureUrl(employee.getProfilePictureUrl());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        return employeeRepository.findByDepartmentContainingIgnoreCase(department);
    }
}