package ekam.example.api;

import com.testvagrant.ekam.testBases.testng.APITest;
import ekam.example.api.clients.ToDosClient;
import ekam.example.api.response.ToDos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;

@Test(groups = {"api", "todos"})
public class ToDosServiceTests extends APITest {

    public void getToDosShouldReturnAValue() {
        List<ToDos> toDos = Client(ToDosClient.class).getToDos();
        Assert.assertTrue(toDos.size() > 1);
    }
}
