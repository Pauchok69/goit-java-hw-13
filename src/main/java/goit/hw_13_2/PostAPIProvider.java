package goit.hw_13_2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostAPIProvider implements PostAPIProviderInterface {
    private static final String POST_API_URI = "https://jsonplaceholder.typicode.com/posts";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public String getAllCommentsByPostRaw(int postId) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(POST_API_URI + "/" + postId + "/comments")).build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (isResponseCode2xx(response.statusCode())) {
                return response.body();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    private boolean isResponseCode2xx(int responseCode) {
        return responseCode >= 200 && responseCode < 300;
    }
}
