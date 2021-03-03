package dto;

public class CreateCustomerInputResponseDTO {

    private int statusCode;
    private boolean error;
    private String errorMessage;

    // Getter Methods

    public int getStatusCode() {
        return statusCode;
    }
    public boolean getError() {
        return error;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    // Setter Methods

    public void setStatusCode( int statusCode ) {
        this.statusCode = statusCode;
    }
    public void setError( boolean error ) {
        this.error = error;
    }
    public void setErrorMessage( String errorMessage ) {
        this.errorMessage = errorMessage;
    }

}
