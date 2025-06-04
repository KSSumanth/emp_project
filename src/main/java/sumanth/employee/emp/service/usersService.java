package sumanth.employee.emp.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sumanth.employee.emp.model.users;
import sumanth.employee.emp.repository.*;

@Service
public class usersService implements UserDetailsService{
    @Autowired
    private usersRepo repo;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public users newUser(users users){
        return repo.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("user "+username+" trying fetch the details");
        users Users = repo.findByUsername(username);
        if(Users==null)
            throw new UsernameNotFoundException(username);
        logger.info(username+" matched");
        return Users;
    }
}
