package com.project.springbootrest.ropo;

import com.project.springbootrest.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUsers,Integer> {

    Optional<AppUsers> findByUsername(String username);

}
