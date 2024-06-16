package com.meta.client.core;

import com.meta.client.remote.users.UserClient;
import com.meta.common.pojos.Config;
import com.meta.common.pojos.Result;
import com.meta.common.pojos.UserResponse;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuvraj Singh
 */
public class SocialManagerImpl implements SocialManager{
    private final UserClient userClient;

    public SocialManagerImpl(Config config, UserResponse user) {
        this.userClient = new UserClient(config.getBaseUrl(), user.getToken());
    }

    @Override
    public CompletableFuture<Result> registerUser(UserDetails userDetails) {
        return userClient.registerUser(userDetails);
    }
}
