package ekam.example.api.clients;

import com.google.gson.JsonObject;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.commons.annotations.APIStep;
import ekam.example.api.clients.services.PostsService;
import ekam.example.api.response.Posts;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class PostsClient extends RetrofitBaseClient {
    private final PostsService service;

    @Inject
    public PostsClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(PostsService.class);
    }

    @APIStep(description = "Get Posts")
    public List<Posts> getPosts() {
        Call<List<Posts>> call = service.getPosts();
        return httpClient.execute(call);
    }

    @APIStep(description = "Get Posts")
    public Response<List<Posts>> getPost(String id) {
        Call<List<Posts>> call = service.getPost(id);
        return httpClient.executeAsResponse(call);
    }

    @APIStep(description = "Create Post")
    public Posts createPost(Posts post) {
        Call<Posts> call = service.createPost(post);
        return httpClient.execute(call);
    }

    @APIStep(description = "Delete post")
    public Response<JsonObject> deletePost(String postId) {
        Call<JsonObject> call = service.deletePost(postId);
        return httpClient.executeAsResponse(call);
    }

    @APIStep(description = "Update  post")
    public Posts updatePost(Posts post) {
        Call<Posts> call = service.updatePost(post.getUserId(), post);
        return httpClient.execute(call);
    }

    @APIStep(description = "Update  post")
    public Posts editPost(Posts post) {
        Call<Posts> call = service.editPost(post.getUserId(), post);
        return httpClient.execute(call);
    }
}
