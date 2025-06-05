// package sumanth.employee.emp.service;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import sumanth.employee.emp.model.Employee;
// import sumanth.employee.emp.repository.EmployeeRepository;

// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// public class EmployeeServiceTest{

//     @Mock
//     private EmployeeRepository employeeRepository;

//     @InjectMocks
//     private EmployeeService employeeService;

//     private Employee employee;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//         employee = new Employee();
//         employee.setId(1L);
//         employee.setName("John Doe");
//         employee.setDepartment("Engineering");
//         employee.setJobTitle("Developer");
//         employee.setEmail("john.doe@example.com");
//         employee.setPhoneNumber("1234567890");
//     }

//     @Test
//     public void testCreateEmployee() {
//         when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
//         Employee createdEmployee = employeeService.createEmployee(employee);
//         assertNotNull(createdEmployee);
//         assertEquals("John Doe", createdEmployee.getName());
//         verify(employeeRepository, times(1)).save(employee);
//     }

//     @Test
//     public void testGetEmployeeById() {
//         when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
//         Optional<Employee> foundEmployee = employeeService.getEmployeeById(1L);
//         assertTrue(foundEmployee.isPresent());
//         assertEquals("John Doe", foundEmployee.get().getName());
//     }

//     // Add more tests for update, delete, etc.
// }



   package sumanth.employee.emp.service;

   import org.junit.jupiter.api.BeforeEach;
   import org.junit.jupiter.api.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;
   import org.mockito.MockitoAnnotations;

   import sumanth.employee.emp.model.Employee;
   import sumanth.employee.emp.repository.EmployeeRepository;

   import java.util.Optional;

   import static org.junit.jupiter.api.Assertions.*;
   import static org.mockito.Mockito.*;

   public class EmployeeServiceTest {

       @Mock
       private EmployeeRepository employeeRepository;

       @InjectMocks
       private EmployeeServiceImpl employeeService; // Use the implementation class

       private Employee employee;

       @BeforeEach
       public void setUp() {
           MockitoAnnotations.openMocks(this);
           employee = new Employee();
           employee.setId(1L);
           employee.setName("John Doe");
           employee.setDepartment("Engineering");
           employee.setJobTitle("Developer");
           employee.setEmail("john.doe@example.com");
           employee.setPhoneNumber("1234567890");
       }

       @Test
       public void testCreateEmployee() {
           when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
           Employee createdEmployee = employeeService.createEmployee(employee);
           assertNotNull(createdEmployee);
           assertEquals("John Doe", createdEmployee.getName());
           verify(employeeRepository, times(1)).save(employee);
       }

       @Test
       public void testGetEmployeeById() {
           when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
           Optional<Employee> foundEmployee = employeeService.getEmployeeById(1L);
           assertTrue(foundEmployee.isPresent());
           assertEquals("John Doe", foundEmployee.get().getName());
       }

       // Add more tests for update, delete, etc.
   }
   