package ekam.example.api.clients;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.commons.annotations.APIStep;
import ekam.example.api.clients.services.ToDosService;
import ekam.example.api.response.ToDos;
import retrofit2.Call;

import java.util.List;

public class ToDosClient extends RetrofitBaseClient {

    private final ToDosService service;

    @Inject
    public ToDosClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(ToDosService.class);
    }

    @APIStep(description = "Get TODOS")
    public List<ToDos> getToDos() {
        Call<List<ToDos>> call = service.getToDos();
        return httpClient.execute(call);
    }
}
