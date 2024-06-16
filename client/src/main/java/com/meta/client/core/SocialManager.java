package com.meta.client.core;

import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuvraj Singh
 */
public interface SocialManager {
    CompletableFuture<Result> registerUser(UserDetails userDetails);
}
