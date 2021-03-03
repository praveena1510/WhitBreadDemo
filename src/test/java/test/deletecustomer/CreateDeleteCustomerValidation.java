package test.deletecustomer;

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

public class CreateDeleteCustomerValidation {

    @DataProvider
    public Object[][] getCustomerData() throws IOException, ParseException {
        return Utility.getInputData("src/test/resources/DeleteCustomerValidation.json");
    }

    @Test(dataProvider = "getCustomerData")
    public void deleteCustomerValidation(CreateCustomerInputDTO createCustomerInputDTO) throws JsonProcessingException {
        Response response = ServiceCalls.deleteCustomer(createCustomerInputDTO.getRq().getDeleteEmail());
        Assertions.validateDeleteCustomerResponse(response, createCustomerInputDTO.getRs());
    }

}
