package Models;

public class Person {
    // attributes
    private String id;
    private String cin;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // constructor
    public Person(String id, String cin, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // getters
    public String getID() { return this.id; }
    public String getCIN() { return this.cin; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public String getPhone() { return this.phone; }
}
