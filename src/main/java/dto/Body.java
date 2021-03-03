package dto;

public class Body {

    private String customerId;
    private String sessionId;
    private boolean success;

    // Getter Methods

    public String getCustomerId() {
        return customerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean getSuccess() {
        return success;
    }

    // Setter Methods

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}