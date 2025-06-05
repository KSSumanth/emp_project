package sumanth.employee.emp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import sumanth.employee.emp.model.Employee;
import sumanth.employee.emp.service.EmployeeService;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

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
    public void testGetAllEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));
        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());
    }

    @Test
    public void testCreateEmployee() {
        when(employeeService.createEmployee(any(Employee.class))).thenReturn(employee);
        ResponseEntity<Employee> response = employeeController.createEmployee(employee);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("John Doe", response.getBody().getName());
    }

}

       