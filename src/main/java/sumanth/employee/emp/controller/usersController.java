package sumanth.employee.emp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sumanth.employee.emp.model.users;
import sumanth.employee.emp.service.usersService;

@RestController
@RequestMapping("/api/users")
public class usersController {
    @Autowired
    private usersService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // SignUp
    @PostMapping("/")
    public users createNewUSer(@RequestBody users Users){
        Users.setPassword(passwordEncoder.encode(Users.getPassword()));
        return service.newUser(Users);
    }
}
