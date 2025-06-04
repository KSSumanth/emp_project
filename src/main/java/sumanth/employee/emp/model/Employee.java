// package sumanth.employee.emp.model;


// import jakarta.persistence.*;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
// import lombok.*;

// import java.time.LocalDate;

// @Entity
// @Table(name = "employees")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Employee {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank(message = "Employee name is required")
//     private String name;

//     @NotBlank(message = "Department is required")
//     private String department;

//     @NotBlank(message = "Job title is required")
//     private String jobTitle;

//     @Email(message = "Email should be valid")
//     private String email;

//     @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
//     private String phoneNumber;

//     private String address;

//     private LocalDate joiningDate;

//     private String managerName;

//     private String profilePictureUrl; // optional
// }



// package sumanth.employee.emp.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import lombok.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "employees")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class Employee {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank(message = "Name is mandatory")
//     @Size(min = 2, max = 50, message = "Name must be 2-50 characters")
//     private String name;

//     @NotBlank(message = "Department is mandatory")
//     private String department;

//     @NotBlank(message = "Job title is mandatory")
//     private String jobTitle;

//     @Email(message = "Email must be valid")
//     @NotBlank(message = "Email is mandatory")
//     private String email;

//     @Pattern(regexp = "^\\d{10}$", message = "Phone must be 10 digits")
//     private String phoneNumber;

//     private String address;  // Optional field

//     @PastOrPresent(message = "Joining date cannot be in the future")
//     private LocalDate joiningDate;

//     private String managerName;  // Optional field

//     @Column(name = "profile_picture_url")
//     private String profilePictureUrl;  // Optional field
// }







package sumanth.employee.emp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be 2-50 characters")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Department is mandatory")
    private String department;

    @Column(nullable = false)
    @NotBlank(message = "Job title is mandatory")
    private String jobTitle;

    @Column(nullable = false)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Phone must be 10 digits")
    private String phoneNumber;

    private String address;  // Optional field

    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate joiningDate;

    private String managerName;  // Optional field

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;  // Optional field
}