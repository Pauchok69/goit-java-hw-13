package goit.hw_13_1;

public class UserApiProviderTests {
    public static void main(String[] args) {
        UserAPIProvider userAPIProvider = new UserAPIProvider();

        System.out.println("userAPIProvider.getUsers() = " + userAPIProvider.getUsers());

        System.out.println("userAPIProvider.getUser(1) = " + userAPIProvider.getUser(1));
        System.out.println("userAPIProvider.getUser(5) = " + userAPIProvider.getUser(5));
        System.out.println("userAPIProvider.getUser(99) = " + userAPIProvider.getUser(99));

        System.out.println("userAPIProvider.getUserByUsername(\"test\") = " + userAPIProvider.getUserByUsername("test"));
        System.out.println("userAPIProvider.getUserByUsername(\"Bret\") = " + userAPIProvider.getUserByUsername("Bret"));

        User newUser = new User();
        newUser.setEmail("andy_testd2@test.com");
        newUser.setUsername("andy123d5");
        newUser.setName("Andy Bandg");
        newUser.setPhone("9999 333 333");
        System.out.println("userAPIProvider.createUser(newUser) = " + userAPIProvider.createUser(newUser));
    }
}
