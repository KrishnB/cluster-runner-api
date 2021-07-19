package ekam.example.api.clients.services;

import ekam.example.api.response.ToDos;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ToDosService {

    @GET("/todos")
    Call<List<ToDos>> getToDos();
}
