package com.meta.server.users.service;

import org.springframework.stereotype.Service;
import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuvraj Singh
 */
@Service
public interface UserService {
    CompletableFuture<Result> registerUser(UserDetails userDetails);
}
