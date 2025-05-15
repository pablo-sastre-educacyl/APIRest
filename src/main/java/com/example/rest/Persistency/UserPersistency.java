package com.example.rest.Persistency;

import com.example.rest.Entities.User;

import java.util.List;

public interface UserPersistency {
    //metodos
    public List<User> getAll();
    public List<User> getOne(int id);
    public List<User> setUser(String nombre, int anno);
    public List<User> delUserId(int id);
    public List<User> updateUser(int id, String nombre, int anno);
    public List<User> deleteAll();
}
