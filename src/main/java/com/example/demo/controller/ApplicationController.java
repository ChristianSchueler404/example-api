package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1")
public class ApplicationController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        log.info("POST Safe new User");
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        Iterable<User> all = getAll();

        for(User user: all) {
            if(user.getEmail().equals(n.getEmail())){
                log.info("Duplicate email, could not save");
                return "Duplicate email, could not save";
            }
        }
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    private Iterable<User> getAll() {
        log.info("GET All Users");
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    private Optional<User> getUser(@PathVariable int id) {
        log.info("GET User id: {}", id);
        return userRepository.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    private void deleteUserbyId(@PathVariable int id){
        log.info("Delete User id: {}", id);
        userRepository.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    private String deleteAllUsers(){
        log.info("Delete ALL Users");
        userRepository.deleteAll();
        return "Deleted All Users";
    }

}
