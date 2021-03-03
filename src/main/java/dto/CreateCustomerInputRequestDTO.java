package dto;

public class CreateCustomerInputRequestDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private String fetchEmail;
    private String deleteEmail;
    private String password;

    // Getter Methods

    public String getEmail() {
        return email;
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

    public String getFetchEmail() { return fetchEmail; }

    public String getDeleteEmail() { return deleteEmail; }

    public String getPassword() { return password; }

    // Setter Methods

    public void setEmail( String email ) {
        this.email = email;
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

    public void setFetchEmail( String fetchEmail ) {
        this.fetchEmail = fetchEmail;
    }

    public void setDeleteEmail( String deleteEmail ) {
        this.deleteEmail = deleteEmail;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

}
