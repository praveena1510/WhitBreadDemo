package test.createcustomer;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.CreateCustomerInputDTO;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Utility;

import java.io.IOException;

public class CreateCustomerValidation {

    @DataProvider
    public Object[][] getCustomerData() throws IOException, ParseException {
        return Utility.getInputData("src/test/resources/createCustomerValidation.json");
    }

    @Test(dataProvider = "getCustomerData")
    public void createCustomerValidation(CreateCustomerInputDTO createCustomerInputDTO) throws JsonProcessingException {
        Utility.createAndValidateConsumer(createCustomerInputDTO);
    }

}
