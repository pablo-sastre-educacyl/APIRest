package com.example.rest.Persistency;

import com.example.rest.Entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPersistencyImpl  implements  UserPersistency{

    final String json_url = "users.json";
    final ObjectMapper mapper = new ObjectMapper();


    @Override
    public List<User> getAll() {

        try{
            File json = new File(json_url);
            return mapper.readValue(json, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> getOne(int id) {
        List<User> users = getAll();
        for(User u: users){
            if(u.getId() == id){
                return List.of(u);
            }
        }
        return List.of();
    }

    @Override
    public List<User> setUser(String nombre, int anno) {
        try{
            User nuevo = new User(primerId(), nombre, anno);
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
    public List<User> deleteAll(){
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
    public List<User> updateUser(int id, String nombre, int anno) {
        try{
            User nuevo = new User(id, nombre, anno);
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
    }
}
