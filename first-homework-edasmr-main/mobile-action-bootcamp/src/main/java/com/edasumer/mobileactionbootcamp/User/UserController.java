package com.edasumer.mobileactionbootcamp.User;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserDAO userDao;


// bütün kullanıcıları getirme
    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){

        List<User> userList = userDao.findAll();

        return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);
    }
//idye göre getirme
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@RequestParam long id){
        User user = userDao.findById(id).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

     // kullanıcı update (existe göre)
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        boolean isExists = userDao.existsById(user.getId());

        if (!isExists){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    //kullanıcı kaydı yapma
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // sadece aktif pasif olayi için patch kullanıldı. kullanıcyı aktif pasif yapma
    @PatchMapping("passive/{id}")
    public ResponseEntity makeUserPassive(@RequestParam long id){
        User user = userDao.findById(id).orElseThrow();
        user.setActive(false);
        user = userDao.save(user);
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }
}