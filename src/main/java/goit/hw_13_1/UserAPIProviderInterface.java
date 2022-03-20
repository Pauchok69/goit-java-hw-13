package goit.hw_13_1;

import java.util.List;

public interface UserAPIProviderInterface {
    int createUser(User user);

    void updateUser(User user);

    boolean deleteUser(int userId);

    List<User> getUsers();

    User getUser(int userId);

    User getUserByUsername(String username);
}
