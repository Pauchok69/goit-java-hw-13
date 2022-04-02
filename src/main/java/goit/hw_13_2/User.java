package goit.hw_13_2;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    @Data
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Data
        public static class Geo {
            private float lat;
            private float lng;
        }
    }

    @Data
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }
}
