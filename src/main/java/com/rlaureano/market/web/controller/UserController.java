package com.rlaureano.market.web.controller;

import com.rlaureano.market.domain.User;
import com.rlaureano.market.domain.repository.UserRepository;
import com.rlaureano.market.domain.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    private UserDetailService userDetailService;
    @PostMapping("/save")
    public ResponseEntity<User> save(User user){
        return new ResponseEntity<>(userDetailService.save(user), HttpStatus.CREATED);
    }
}
