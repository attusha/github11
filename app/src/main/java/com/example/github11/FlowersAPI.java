package com.example.github11;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface FlowersAPI {
    // GET /repos/:owner/:repo/contributors

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Flower>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}