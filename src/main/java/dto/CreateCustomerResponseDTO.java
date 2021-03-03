package dto;

public class CreateCustomerResponseDTO {

    private int statusCode;
    Headers headersObject;
    Body bodyObject;

    // Getter Methods

    public int getStatusCode() {
        return statusCode;
    }

    public Headers getHeaders() {
        return headersObject;
    }

    public Body getBody() {
        return bodyObject;
    }

    // Setter Methods

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(Headers headersObject) {
        this.headersObject = headersObject;
    }

    public void setBody(Body bodyObject) {
        this.bodyObject = bodyObject;
    }
}