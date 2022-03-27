package goit.hw_13_1;

public class UserApiProviderTests {
    public static void main(String[] args) {
        UserAPIProvider userAPIProvider = new UserAPIProvider();

        System.out.println("userAPIProvider.getUsers() = " + userAPIProvider.getUsers());

        System.out.println("userAPIProvider.getUser(1) = " + userAPIProvider.getUser(1));
        System.out.println("userAPIProvider.getUser(99) = " + userAPIProvider.getUser(99));

        System.out.println("userAPIProvider.getUserByUsername(\"test\") = " + userAPIProvider.getUserByUsername("test"));
        System.out.println("userAPIProvider.getUserByUsername(\"Bret\") = " + userAPIProvider.getUserByUsername("Bret"));
    }
}
