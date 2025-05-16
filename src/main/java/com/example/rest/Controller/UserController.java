package com.example.rest.Controller;

import com.example.rest.Entities.User;

import com.example.rest.Persistency.UserPersistency;
import com.example.rest.Persistency.UserPersistencyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/empleados")
public class UserController {
    private final UserPersistency userPersistency;


    @Autowired
    public UserController(UserPersistency userPersistency) {
        this.userPersistency = userPersistency;
    }
    @GetMapping()
    public List<User> Get(){
        return userPersistency.findAll();
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }
    @GetMapping("/{id}")
    public Optional<User> GetOne(@PathVariable("id") int id){
        Optional<User> u = userPersistency.findById(id);
        if (u.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return u;
    }
    @PostMapping()
    public User SetUser(@RequestBody User u){
        List<User> users = Get();
        return userPersistency.save(new User(primerId(users), u.getNombre(), u.getFecha_nac()));
    }
    @DeleteMapping("/{id}")
    public Optional<User> DelUserId(@PathVariable("id") int id){
        if(GetOne(id).isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<User> u = GetOne(id);
        userPersistency.deleteById(id);
        return u;
    }
    /*@DeleteMapping()
    public List<User>  deleteAll(){
        return userPersistency.deleteAllM();
    }*/
    @PutMapping("/{id}")
    public List<Object> updateUser(@RequestBody User u, @PathVariable("id") int id){
        if(GetOne(id).isEmpty()){
            throw new ResourceNotFoundException();
        }
        Optional<User> u2 = GetOne(id);
        DelUserId(id);
        SetUser(new User(id, u.getNombre(), u.getFecha_nac()));
        return (List.of(u2, new User(id, u.getNombre(), u.getFecha_nac())));
    }

    public int primerId(List<User> users){
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

