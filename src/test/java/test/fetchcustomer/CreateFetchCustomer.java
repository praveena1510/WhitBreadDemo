package test.fetchcustomer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class CreateFetchCustomer {

    public static String customerId;
    public static CreateCustomerInputResponseDTO createCustomerInputResponseDTO;

    @DataProvider
    public Object[][] getCustomerData() throws IOException, ParseException {
        return Utility.getInputData("src/test/resources/FetchCustomer.json");
    }

    @Test(dataProvider = "getCustomerData")
    public void createCustomer(CreateCustomerInputDTO createCustomerInputDTO) throws JsonProcessingException {
        Response response = Utility.createAndValidateConsumer(createCustomerInputDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateCustomerResponseDTO createCustomerResponseDTO = objectMapper.readValue(response.asString(),
                CreateCustomerResponseDTO.class);
        customerId = createCustomerResponseDTO.getBody().getCustomerId();
        createCustomerInputResponseDTO = createCustomerInputDTO.getRs();
    }

    @Test(dependsOnMethods = { "createCustomer" })
    public void fetchCustomer() throws JsonProcessingException {
        Response response = ServiceCalls.fetchCustomer(customerId);
        Assertions.validateFetchCustomerResponse(response, customerId, createCustomerInputResponseDTO);
    }

}
