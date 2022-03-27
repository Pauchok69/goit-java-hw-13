package goit.hw_13_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserApiProviderTests {
    public static void main(String[] args) {
        UserAPIProvider userAPIProvider = new UserAPIProvider();

        // Get all users
        System.out.println("userAPIProvider.getUsers() = " + userAPIProvider.getUsers());

        // Get user by id
        System.out.println("userAPIProvider.getUser(1) = " + userAPIProvider.getUser(1));
        System.out.println("userAPIProvider.getUser(5) = " + userAPIProvider.getUser(5));
        System.out.println("userAPIProvider.getUser(99) = " + userAPIProvider.getUser(99));

        // Get user by username
        System.out.println("userAPIProvider.getUserByUsername(\"test\") = " + userAPIProvider.getUserByUsername("test"));
        System.out.println("userAPIProvider.getUserByUsername(\"Bret\") = " + userAPIProvider.getUserByUsername("Bret"));

        // Create new User
        User newUser = new User();
        newUser.setEmail("andy_testd2@test.com");
        newUser.setUsername("andy123d5");
        newUser.setName("Andy Bandg");
        newUser.setPhone("9999 333 333");
        System.out.println("userAPIProvider.createUser(newUser) = " + userAPIProvider.createUser(newUser));

        // Update User
        int userIdToUpdate = 3;
        System.out.println("userAPIProvider.getUser(userIdToUpdate) = " + userAPIProvider.getUser(userIdToUpdate));
        Map<String, Object> dataToUpdate = new HashMap<>();
        dataToUpdate.put("username", "Bingo");
        dataToUpdate.put("phone", "9999 33 222");
        System.out.println("userAPIProvider.updateUser(userIdToUpdate, dataToUpdate) = " + userAPIProvider.updateUser(userIdToUpdate, dataToUpdate));
//        System.out.println("userAPIProvider.updateUser(userIdToUpdate, dataToUpdate) = " + userAPIProvider.updateUser(77, dataToUpdate));
//        System.out.println("userAPIProvider.updateUser(userIdToUpdate, dataToUpdate) = " + userAPIProvider.updateUser(userIdToUpdate, Collections.emptyMap()));
        System.out.println("userAPIProvider.getUser(userIdToUpdate) = " + userAPIProvider.getUser(userIdToUpdate));

        // Delete user
        System.out.println("userAPIProvider.deleteUser(1) = " + userAPIProvider.deleteUser(1));
        System.out.println("userAPIProvider.deleteUser(99) = " + userAPIProvider.deleteUser(99));
    }
}
