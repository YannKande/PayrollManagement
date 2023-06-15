package com.csc.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import csc.UserServices;
import lombok.SneakyThrows;
import model.user.LoginRequest;
import model.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("EmployedManagement/v1")
public class Auth {

    ObjectMapper mapper;
    UserServices services;

    @SneakyThrows
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        String user=services.login(request);

        if(!user.isEmpty()) return new String(mapper.writeValueAsString(user));

        return ResponseEntity.notFound().toString();
    }

}
