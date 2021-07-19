package ekam.example.api;

import com.google.gson.JsonObject;
import com.testvagrant.ekam.testBases.testng.APITest;
import ekam.example.api.clients.PostsClient;
import ekam.example.api.response.Posts;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;
import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = "api")
@Epic("Posts Service")
@Feature("CRUD operations on Posts")
public class PostsServiceTest extends APITest {

    @Story("GET A POST")
    public void getPostsShouldReturnAValue() {
        PostsClient postsClient = Client(PostsClient.class);
        List<Posts> posts = postsClient.getPosts();
        Assert.assertTrue(posts.size() > 1);
    }

    @Story("CREATE (POST) A  NEW POST")
    public void createANewPost() {
        Posts postToCreate = Posts.builder().build().createDefaultPost();
        PostsClient postsClient = Client(PostsClient.class);
        Posts createdPost = postsClient.createPost(postToCreate);
        postToCreate.assertThatPostIsCreated(createdPost);
    }

    @Story("UPDATE A  NEW POST")
    public void updatePost() {
        Posts post = createAPost();
        post.setTitle("Hello World");
        post.setBody("My First post");
        Posts updatePost = Client(PostsClient.class).updatePost(post);
        assertThat(updatePost.getId()).isEqualTo("1");
    }

    @Story("EDIT A  NEW POST")
    public void editPost() {
        Posts post = createAPost();
        post.setTitle("Hello World");
        Posts updatedPost = Client(PostsClient.class).editPost(post);
        post.assertThatPostIsCreated(updatedPost);
    }


    @Story("DELETE A  NEW POST")
    public void deletePost() {
        Posts posts = createAPost();
        Response<JsonObject> createdPost = Client(PostsClient.class).deletePost(posts.getId());
        assertThat(createdPost.code()).isEqualTo(200);
        assertThat(createdPost.body().toString()).isEqualTo("{}");
    }

    private Posts createAPost() {
        Posts postToCreate = Posts.builder().build().createDefaultPost();
        PostsClient postsClient = Client(PostsClient.class);
        Posts createdPost = postsClient.createPost(postToCreate);
        return createdPost;
    }
}
