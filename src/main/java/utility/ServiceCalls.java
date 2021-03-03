package utility;

import dto.CreateCustomerRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServiceCalls {

    public static final String  BASE_URI = "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/";

    public static RequestSpecification getRequestSpecification() {
        RestAssured.baseURI = BASE_URI;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        return requestSpecification;
    }

    public static Response createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO) {
        Response response = getRequestSpecification().body(createCustomerRequestDTO).when().post();
        return response;
    }

    public static Response deleteCustomer(String customerId) {
        Response response = getRequestSpecification().delete("/"+customerId);
        return response;
    }

    public static Response fetchCustomer(String customerId) {
        Response response = getRequestSpecification().get("/"+customerId);
        return response;

    }

}
