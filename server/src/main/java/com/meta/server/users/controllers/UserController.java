package com.meta.server.users.controllers;

import com.meta.server.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuvraj Singh
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity<Result>> registerUser(@RequestBody UserDetails userDetails) {
        return userService.registerUser(userDetails).thenApply(ResponseEntity::ok).exceptionally((e) -> ResponseEntity.internalServerError().body(
                new Result(1, "Error registering user: " + e.getMessage())
        ));
    }
}
