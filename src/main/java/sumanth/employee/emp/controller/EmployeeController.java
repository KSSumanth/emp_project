// package sumanth.employee.emp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.service.EmployeeService;

// import java.util.List;

// @RestController
// @RequestMapping("/api/employees")
// @CrossOrigin(origins = "*") // Allow frontend access if running on different port
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @GetMapping
//     public List<Employee> getAllEmployees() {
//         return employeeService.getAllEmployees();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//         return employeeService.getEmployeeById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public Employee createEmployee(@RequestBody Employee employee) {
//         return employeeService.createEmployee(employee);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//         try {
//             return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//         return ResponseEntity.noContent().build();
//     }
// }




// package sumanth.employee.emp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.service.EmployeeService;

// import jakarta.validation.Valid;
// import java.util.List;

// @RestController
// @RequestMapping("/api/employees")
// @CrossOrigin(origins = "*") // Allow frontend access
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     // Get all employees
//     @GetMapping
//     public ResponseEntity<List<Employee>> getAllEmployees() {
//         List<Employee> employees = employeeService.getAllEmployees();
//         return ResponseEntity.ok(employees);
//     }

//     // Get employee by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//         return employeeService.getEmployeeById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     // Create new employee
//     @PostMapping
//     public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//         Employee savedEmployee = employeeService.createEmployee(employee);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
//     }

//     // Update existing employee
//     @PutMapping("/{id}")
//     public ResponseEntity<Employee> updateEmployee(
//             @PathVariable Long id,
//             @Valid @RequestBody Employee employee
//     ) {
//         try {
//             Employee updatedEmployee = employeeService.updateEmployee(id, employee);
//             return ResponseEntity.ok(updatedEmployee);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     // Delete employee
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//         return ResponseEntity.noContent().build();
//     }

//     // Search employees by department
//  @GetMapping("/search")
// public ResponseEntity<?> searchEmployeesByDepartment(
//         @RequestParam String department) {
//     try {
//         List<Employee> employees = employeeService.findByDepartment(department);
//         return ResponseEntity.ok(employees);
//     } catch (IllegalArgumentException e) {
//         return ResponseEntity.badRequest().body(e.getMessage());
//     }
// }
// }










// package sumanth.employee.emp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.*;
// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.service.EmployeeService;

// import jakarta.validation.Valid;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/employees")
// @CrossOrigin(origins = "*")
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @GetMapping
//     public ResponseEntity<List<Employee>> getAllEmployees() {
//         List<Employee> employees = employeeService.getAllEmployees();
//         return ResponseEntity.ok(employees);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//         return employeeService.getEmployeeById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//         Employee savedEmployee = employeeService.createEmployee(employee);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Employee> updateEmployee(
//             @PathVariable Long id,
//             @Valid @RequestBody Employee employee
//     ) {
//         try {
//             Employee updatedEmployee = employeeService.updateEmployee(id, employee);
//             return ResponseEntity.ok(updatedEmployee);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/search")
//     public ResponseEntity<?> searchEmployeesByDepartment(
//             @RequestParam String department) {
//         try {
//             List<Employee> employees = employeeService.findByDepartment(department);
//             return ResponseEntity.ok(employees);
//         } catch (IllegalArgumentException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//         Map<String, String> errors = new HashMap<>();
//         ex.getBindingResult().getFieldErrors().forEach(error -> {
//             errors.put(error.getField(), error.getDefaultMessage());
//         });
//         return errors;
//     }
// }





package sumanth.employee.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sumanth.employee.emp.model.Employee;
import sumanth.employee.emp.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
 @PreAuthorize("hasAuthority('admin')")
    @PostMapping
public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
    Employee savedEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
}
 @PreAuthorize("hasAnyAuthority('admin','user')")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
 @PreAuthorize("hasAnyAuthority('admin','user')")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(null);
        }
        
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
 @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
 @PreAuthorize("hasAnyAuthority('admin','user')")
    @GetMapping("/search/department")
    public ResponseEntity<?> searchEmployeesByDepartment(
            @RequestParam String department) {
        try {
            List<Employee> employees = employeeService.findByDepartment(department);
            return ResponseEntity.ok(employees);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
       @GetMapping("/search/name")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String name) {
        List<Employee> employees = employeeService.findByName(name);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/search/jobTitle")
    public ResponseEntity<List<Employee>> searchEmployeesByJobTitle(@RequestParam String jobTitle) {
        List<Employee> employees = employeeService.findByJobTitle(jobTitle);
        return ResponseEntity.ok(employees);
    }
}