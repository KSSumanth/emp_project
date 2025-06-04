package sumanth.employee.emp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sumanth.employee.emp.model.users;

@Repository
public interface usersRepo extends JpaRepository<users,Integer>{
 users findByUsername(String username);
}
