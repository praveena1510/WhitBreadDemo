package dto;

public class CreateCustomerInputDTO {

    private int useCase;
    private String description;
    private CreateCustomerInputRequestDTO rq;
    private CreateCustomerInputResponseDTO rs;

    // Getter Methods

    public CreateCustomerInputResponseDTO getRs() {
        return rs;
    }

    public CreateCustomerInputRequestDTO getRq() { return rq; }

    public String getDescription() {
        return description;
    }

    public int getUseCase() { return useCase; }

    // Setter Methods

    public void setRs( CreateCustomerInputResponseDTO rs ) {
        this.rs = rs;
    }

    public void setRq( CreateCustomerInputRequestDTO rq ) {
        this.rq = rq;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public void setUseCase( int rq ) {
        this.useCase = useCase;
    }

}
