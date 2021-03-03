package builder;

import dto.CreateCustomerInputDTO;
import dto.CreateCustomerRequestDTO;

public class RequestBuilder {

    public  static CreateCustomerRequestDTO createCustomerRequestDTO(CreateCustomerInputDTO createCustomerInputDTO) {
        CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
        createCustomerRequestDTO.setEmail(createCustomerInputDTO.getRq().getEmail());
        createCustomerRequestDTO.setFirstName(createCustomerInputDTO.getRq().getFirstName());
        createCustomerRequestDTO.setLastName(createCustomerInputDTO.getRq().getLastName());
        createCustomerRequestDTO.setTitle(createCustomerInputDTO.getRq().getTitle());
        createCustomerRequestDTO.setPassword(createCustomerInputDTO.getRq().getTitle());
        return createCustomerRequestDTO;
    }

}
