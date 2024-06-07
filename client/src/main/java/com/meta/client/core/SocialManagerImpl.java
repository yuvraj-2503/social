package com.meta.client.core;

import com.meta.client.remote.users.UserClient;
import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;

public class SocialManagerImpl implements SocialManager{
    private final UserClient userClient;

    public SocialManagerImpl(String serverUrl) {
        this.userClient = new UserClient(serverUrl);
    }

    @Override
    public CompletableFuture<Result> registerUser(UserDetails userDetails) {
        return userClient.registerUser(userDetails);
    }
}
