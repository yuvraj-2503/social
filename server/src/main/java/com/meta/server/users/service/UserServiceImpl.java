package com.meta.server.users.service;

import com.meta.server.users.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yuvraj Singh
 */
@Service
public class UserServiceImpl implements UserService {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public CompletableFuture<Result> registerUser(UserDetails userDetails) {
        return CompletableFuture.supplyAsync(() -> {
            var userExists = usersRepository.findByEmailId(userDetails.getEmailId());
            if (userExists.isPresent()){
               return new Result(1, "User already exists for given email id: " + userDetails.getEmailId());
            }

            userExists = usersRepository.findByPhoneNumber(userDetails.getPhoneNumber());
            if (userExists.isPresent()){
                return new Result(1, "User already exists for given phone number: " + userDetails.getPhoneNumber().getOriginalNumber());
            }

            var result = usersRepository.save(userDetails);
            return new Result(0, "User data inserted for userId: " + result.getEmailId());
        }, executor);
    }
}
