package com.example.rest.Persistency;

import com.example.rest.Entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public abstract class UserPersistencyImpl implements  UserPersistency{

    final String json_url = "users.json";
    final ObjectMapper mapper = new ObjectMapper();


    /*@Override
    public List<User> getAll() {

        try{
            File json = new File(json_url);
            return mapper.readValue(json, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User getOne(int id) {
        List<User> users = getAll();
        for(User u: users){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> setUser(String nombre, LocalDate fecha) {
        try{
            User nuevo = new User(primerId(), nombre, fecha);
            List<User> users = getAll();
            users.add(nuevo.getId()-1, nuevo);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(json_url), users);
            return List.of(nuevo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> delUserId(int id) {
        try{
            List<User> users = getAll();
            List<User> del = new ArrayList<>(List.of());
            for(User user : users){
                if(user.getId() == id){
                    del.add(user);
                }
            }
            File json = new File(json_url);
            for(User deluser: del){
                users.remove(deluser);
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(json, users);
            return del;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> deleteAllM(){
        try {
            List<User> users = getAll();
            File json = new File(json_url);
            users.clear();
            mapper.writerWithDefaultPrettyPrinter().writeValue(json, users);
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<User> updateUser(int id, String nombre, LocalDate fecha) {
        try{
            User nuevo = new User(id, nombre, fecha);
            List<User> users = getAll();
            int index = -1;
            for(User user: users){
                if(user.getId() == id){
                    index = users.indexOf(user);
                    break;
                }
            }
            if(index >= 0){
                users.remove(users.get(index));
            }
            users.add(nuevo.getId()-1, nuevo);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(json_url), users);
            return List.of(nuevo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Otros metodos
    public int primerId(){
        List<User> users = getAll();
        boolean seguir = true;
        int i = 1;
        int id = 1;
        while(seguir){
            int iguales = 0;
            for(User user : users){
                if(user.getId() == i){
                    iguales ++;
                }
            }
            if(iguales == 0){
                seguir = false;
                id = i;
            }
            i++;
        }
        return id;
        }*/
}

