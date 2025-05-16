package com.example.rest.Persistency;

import com.example.rest.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface UserPersistency extends JpaRepository<User, Integer> {
    //metodos Json

    /*public List<User> getAll();
    public User getOne(int id);
    public List<User> setUser(String nombre, LocalDate fecha);
    public List<User> delUserId(int id);
    public List<User> updateUser(int id, String nombre, LocalDate fecha);
    public List<User> deleteAllM();*/
}
