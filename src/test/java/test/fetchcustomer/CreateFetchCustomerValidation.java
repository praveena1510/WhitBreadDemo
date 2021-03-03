package test.fetchcustomer;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.CreateCustomerInputDTO;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ServiceCalls;
import utility.Utility;
import validation.Assertions;

import java.io.IOException;

public class CreateFetchCustomerValidation {

    @DataProvider
    public Object[][] getCustomerData() throws IOException, ParseException {
        return Utility.getInputData("src/test/resources/FetchCustomerValidation.json");
    }

    @Test(dataProvider = "getCustomerData")
    public void fetchCustomerValidation(CreateCustomerInputDTO createCustomerInputDTO) throws JsonProcessingException {
        Response response = ServiceCalls.fetchCustomer(createCustomerInputDTO.getRq().getFetchEmail());
        Assertions.validateFetchCustomerResponse(response, null, createCustomerInputDTO.getRs());
    }

}
