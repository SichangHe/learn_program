package com.youknowwho.firstjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> listRepo(@Path("owner") String owner, @Path("repo") String repo);
}
