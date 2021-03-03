package utility;

import builder.RequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CreateCustomerInputDTO;
import dto.CreateCustomerRequestDTO;
import dto.CreateCustomerResponseDTO;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import validation.Assertions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static Object[][] getInputData(String file) throws IOException, ParseException {
        JSONArray inputJsonArray = (JSONArray) new JSONParser()
                .parse(new FileReader(file));
        List<CreateCustomerInputDTO> createCustomerInputDTOList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(int i=0;i<inputJsonArray.size();i++) {
            JSONObject jsonObject = (JSONObject) inputJsonArray.get(i);
            CreateCustomerInputDTO createCustomerDTO = mapper.readValue(jsonObject.toString(),
                    CreateCustomerInputDTO.class);
            createCustomerInputDTOList.add(createCustomerDTO);
        }
        Object[][] returnValue = new Object[createCustomerInputDTOList.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = createCustomerInputDTOList.get(index++);
        }
        return returnValue;
    }

    public static Response createAndValidateConsumer(CreateCustomerInputDTO createCustomerInputDTO) throws
            JsonProcessingException {
        CreateCustomerRequestDTO createCustomerRequestDTO =
                RequestBuilder.createCustomerRequestDTO(createCustomerInputDTO);
        Response response = ServiceCalls.createCustomer(createCustomerRequestDTO);
        Assertions.validateCreateCustomerResponse(response, createCustomerRequestDTO, createCustomerInputDTO.getRs());
        return response;
    }

    public static CreateCustomerResponseDTO getCreateCustomerResponseDTO(Response response) throws
            JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.asString(),
                CreateCustomerResponseDTO.class);
    }

}
