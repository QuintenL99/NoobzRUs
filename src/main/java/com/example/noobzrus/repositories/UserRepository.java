package com.example.noobzrus.repositories;



import com.example.noobzrus.models.Userss;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Userss, Integer> {
    Userss findByUsernameAndPassword(String username, String password);
    Userss findByUsername(String username);
}
