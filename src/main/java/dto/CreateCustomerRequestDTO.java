package dto;

public class CreateCustomerRequestDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String title;

    // Getter Methods

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

}
