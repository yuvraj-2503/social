package com.meta.client.remote.users;

import com.meta.common.pojos.Result;
import com.meta.common.users.UserDetails;
import com.meta.restclient.exceptions.RequestFailedException;
import com.meta.restclient.okhttp.BodyRequest;
import com.meta.restclient.okhttp.OkHttpRestClientAsync;
import com.meta.restclient.okhttp.RestClientAsync;
import com.meta.restclient.okhttp.Url;
import com.meta.util.json.Json;

import java.util.concurrent.CompletableFuture;

public class UserClient {
    private final String BASE_URL;
    private final Json json;
    private final RestClientAsync client;

    public UserClient(String baseUrl){
        this.BASE_URL = baseUrl;
        this.json = Json.create();
        this.client = new OkHttpRestClientAsync();
    }

    public CompletableFuture<Result> registerUser(UserDetails userDetails){
        var url = new Url(BASE_URL, "users");
        BodyRequest request = new BodyRequest(url, json.encode(userDetails));
        return client.post(request).thenApply((resp) -> {
            if (resp.getStatusCode() == 200){
                return json.decode(resp.getPayload(), Result.class);
            }
            throw new RequestFailedException("Failed to register user", resp);
        });
    }
}
