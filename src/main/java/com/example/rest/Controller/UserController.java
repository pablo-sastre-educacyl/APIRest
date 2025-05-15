package com.example.rest.Controller;

import com.example.rest.Entities.User;
import com.example.rest.Persistency.UserPersistency;
import com.example.rest.Persistency.UserPersistencyImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/empleados")
public class UserController {
    private final UserPersistency userPersistency;

    public UserController() {
        this.userPersistency = new UserPersistencyImpl();
    }
    @GetMapping()
    public List<User> Get(){
        return userPersistency.getAll();
    }
    @GetMapping("/{id}")
    public List<User> GetOne(@PathVariable("id") int id){
        return userPersistency.getOne(id);
    }
    @PostMapping()
    public List<User> SetUser(@RequestBody User u){
        return userPersistency.setUser(u.getNombre(), u.getAnno_nac());
    }
    @DeleteMapping("/{id}")
    public List<User> DelUserId(@PathVariable("id") int id){
        return userPersistency.delUserId(id);
    }
    @DeleteMapping()
    public List<User>  deleteAll(){
        return userPersistency.deleteAll();
    }
    @PutMapping()
    public List<User>  updateUser(@RequestBody User u){
        return userPersistency.updateUser(u.getId(), u.getNombre(), u.getAnno_nac());
    }
}
