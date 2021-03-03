package dto;

public class CreateCustomerErrorDTO {

    private String errorMessage;
    private String errorType;
    private String[] stackTrace;

    // Getter Methods

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public String[] getStackTrace () { return stackTrace; }

    // Setter Methods

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setStackTrace (String[] stackTrace) { this.stackTrace = stackTrace; }

}