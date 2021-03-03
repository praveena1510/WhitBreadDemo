package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {

    @JsonProperty("Access-Control-Allow-Origin")
    private String accessControlAllowOrigin;

    // Getter Methods

    public String getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    // Setter Methods

    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin;
    }

}