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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAPIProvider implements UserAPIProviderInterface {
    private static final String USER_API_URL = "https://jsonplaceholder.typicode.com/users";
    private final Gson gson = new Gson();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public int createUser(User user) {
        String requestBody = gson.toJson(user);

        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(USER_API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (isResponseCode2xx(response.statusCode())) {
                Type type = new TypeToken<HashMap<String, String>>() {}.getType();
                Map<String, String> body = gson.fromJson(response.body(), type);

                return Integer.parseInt(body.get("id"));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return -1;
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
                Type arrayListType = new TypeToken<ArrayList<User>>() {
                }.getType();

                return gson.<ArrayList<User>>fromJson(response.body(), arrayListType);
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(USER_API_URL + "?username=" + username))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (isResponseCode2xx(response.statusCode())) {
                Type arrayListType = new TypeToken<ArrayList<User>>() {
                }.getType();
                List<User> users = gson.<ArrayList<User>>fromJson(response.body(), arrayListType);

                return users.isEmpty() ? null : users.get(0);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean isResponseCode2xx(int responseCode) {
        return responseCode >= 200 && responseCode < 300;
    }
}
