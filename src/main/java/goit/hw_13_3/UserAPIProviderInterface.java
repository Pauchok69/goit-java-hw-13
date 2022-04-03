package goit.hw_13_3;

import goit.hw_13_2.Post;

import java.util.List;
import java.util.Map;

public interface UserAPIProviderInterface {
    int createUser(User user);

    Map<String, Object> updateUser(int userId, Map<String, Object> data);

    boolean deleteUser(int userId);

    List<User> getUsers();

    User getUser(int userId);

    User getUserByUsername(String username);

    List<Post> getAllPostsByUser(int userId);

    List<Task> getAllUncompletedTasks(int userId);
}
