package com.meta.client.remote.users;

import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;
import com.meta.restclient.exceptions.RequestFailedException;
import com.meta.restclient.okhttp.*;
import com.meta.util.json.Json;

import java.util.concurrent.CompletableFuture;

/**
 * @author Yuvraj Singh
 */
public class UserClient {
    private final String BASE_URL;
    private final Json json;
    private final RestClientAsync client;
    private final String token;

    public UserClient(String baseUrl, String token){
        this.BASE_URL = baseUrl;
        this.token = token;
        this.json = Json.create();
        this.client = new OkHttpRestClientAsync();
    }

    public CompletableFuture<Result> registerUser(UserDetails userDetails){
        var url = new Url(BASE_URL, "users");
        Headers headers = new Headers();
        headers.add("Authorization", "Bearer " + token);
        BodyRequest request = new BodyRequest(url, headers, json.encode(userDetails));
        return client.post(request).thenApply((resp) -> {
            if (resp.getStatusCode() == 200){
                return json.decode(resp.getPayload(), Result.class);
            }
            throw new RequestFailedException("Failed to register user", resp);
        });
    }
}
