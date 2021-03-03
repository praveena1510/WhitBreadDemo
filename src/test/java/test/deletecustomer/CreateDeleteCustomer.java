package test.deletecustomer;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.CreateCustomerInputDTO;
import dto.CreateCustomerInputResponseDTO;
import dto.CreateCustomerResponseDTO;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ServiceCalls;
import utility.Utility;
import validation.Assertions;

import java.io.IOException;

public class CreateDeleteCustomer {

    public static String customerId;
    public static CreateCustomerInputResponseDTO createCustomerInputResponseDTO;

    @DataProvider
    public Object[][] getCustomerData() throws IOException, ParseException {
        return Utility.getInputData("src/test/resources/DeleteCustomer.json");
    }

    @Test(dataProvider = "getCustomerData")
    public void createCustomer(CreateCustomerInputDTO createCustomerInputDTO) throws JsonProcessingException {
        Response response = Utility.createAndValidateConsumer(createCustomerInputDTO);
        CreateCustomerResponseDTO createCustomerResponseDTO = Utility.getCreateCustomerResponseDTO(response);
        customerId = createCustomerResponseDTO.getBody().getCustomerId();
        createCustomerInputResponseDTO = createCustomerInputDTO.getRs();
    }

    @Test(dependsOnMethods = { "createCustomer" })
    public void deleteCustomer() throws JsonProcessingException {
        Response response = ServiceCalls.deleteCustomer(customerId);
        Assertions.validateDeleteCustomerResponse(response, createCustomerInputResponseDTO);
    }

}
