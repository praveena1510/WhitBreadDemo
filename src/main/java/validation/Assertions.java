package validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.*;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Assertions {

    public static final boolean SUCCESS_FLAG = true;

    public static void validateCreateCustomerResponse(Response response,
                                                      CreateCustomerRequestDTO createCustomerRequestDTO,
                                                      CreateCustomerInputResponseDTO createCustomerInputResponseDTO) throws
            JsonProcessingException {
        assertThat("statusCode mismatch for create customer", response.getStatusCode(),
                is(createCustomerInputResponseDTO.getStatusCode()));
        ObjectMapper objectMapper = new ObjectMapper();
        if(createCustomerInputResponseDTO.getError()) {
            CreateCustomerErrorDTO createCustomerErrorDTO = objectMapper.readValue(response.asString(),
                    CreateCustomerErrorDTO.class);
            assertThat("Error message mismatch", createCustomerErrorDTO.getErrorMessage(),
                    is(createCustomerInputResponseDTO.getErrorMessage()));
            assertThat("Error type mismatch", createCustomerErrorDTO.getErrorType(),
                    is("Error"));
            assertThat("Stack trace is empty/null", createCustomerErrorDTO.getStackTrace().length,
                    greaterThan(0));
        } else {
            CreateCustomerResponseDTO createCustomerResponseDTO = objectMapper.readValue(response.asString(),
                    CreateCustomerResponseDTO.class);
            assertThat("Body object is null", createCustomerResponseDTO.getBody(),
                    is(notNullValue()));
            assertThat("Success flag mismatch", createCustomerResponseDTO.getBody().getSuccess(),
                    is(SUCCESS_FLAG));
            assertThat("CustomerId mismatch", createCustomerResponseDTO.getBody().getCustomerId(),
                    is(createCustomerRequestDTO.getEmail().replace("@", "")));
            assertThat("SessionId is empty/null", createCustomerResponseDTO.getBody().getSessionId(),
                    not(isEmptyOrNullString()));
            assertThat("Headers object is null", createCustomerResponseDTO.getHeaders(),
                    not(nullValue()));
            assertThat("Headers object is null", createCustomerResponseDTO.getHeaders().getAccessControlAllowOrigin(),
                    is("*"));
        }
    }

    public static void validateFetchCustomerResponse(Response response, String customerIdExp,
                                                     CreateCustomerInputResponseDTO createCustomerInputResponseDTO) throws
            JsonProcessingException {
        assertThat("statusCode mismatch for fetch customer", response.getStatusCode(),
                is(createCustomerInputResponseDTO.getStatusCode()));
        ObjectMapper objectMapper = new ObjectMapper();
        if(response.getStatusCode() != 200) {
            FetchDeleteCustomerErrorDTO fetchCustomerErrorDTO = objectMapper.readValue(response.asString(),
                    FetchDeleteCustomerErrorDTO.class);
            assertThat("Error message mismatch", fetchCustomerErrorDTO.getMessage(),
                    is(createCustomerInputResponseDTO.getErrorMessage()));
        } else {
            FetchCustomerResponseDTO fetchCustomerResponseDTO = objectMapper.readValue(response.asString(),
                    FetchCustomerResponseDTO.class);
            assertThat("customerId mismatch", fetchCustomerResponseDTO.getCustomerId(), is(customerIdExp));
        }
    }

    public static void validateDeleteCustomerResponse(Response response,
                                                      CreateCustomerInputResponseDTO createCustomerInputResponseDTO) throws
            JsonProcessingException {
        assertThat("statusCode mismatch for delete customer", response.getStatusCode(),
                is(createCustomerInputResponseDTO.getStatusCode()));
        ObjectMapper objectMapper = new ObjectMapper();
        if(response.getStatusCode() != 200) {
            FetchDeleteCustomerErrorDTO deleteCustomerErrorDTO = objectMapper.readValue(response.asString(),
                    FetchDeleteCustomerErrorDTO.class);
            assertThat("Error message mismatch", deleteCustomerErrorDTO.getMessage(),
                    is(createCustomerInputResponseDTO.getErrorMessage()));
        } else {
            DeleteCustomerResponseDTO deleteCustomerResponseDTO = objectMapper.readValue(response.asString(),
                    DeleteCustomerResponseDTO.class);
            assertThat("deleted flag mismatch", deleteCustomerResponseDTO.isDeleted(), is(true));
        }
    }

}
