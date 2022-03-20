package goit.hw_13_1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UserAPIProvider implements UserAPIProviderInterface {
    private static final String USER_API_URL = "https://jsonplaceholder.typicode.com/users";
    private final Gson gson = new Gson();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public List<User> getUsers() {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(USER_API_URL))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (isResponseCode2xx(response.statusCode())) {
                Type fooType = new TypeToken<ArrayList<User>>() {
                }.getType();

                return gson.<ArrayList<User>>fromJson(response.body(), fooType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public User getUser(int userId) {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(USER_API_URL + "/" + userId))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (isResponseCode2xx(response.statusCode())) {
                return gson.fromJson(response.body(), User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    private boolean isResponseCode2xx(int responseCode) {
        return responseCode >= 200 && responseCode < 300;
    }
}