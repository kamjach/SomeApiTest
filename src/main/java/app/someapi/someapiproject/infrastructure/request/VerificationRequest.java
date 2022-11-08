package app.someapi.someapiproject.infrastructure.request;

import lombok.Data;

@Data
public class VerificationRequest {

    private final String email;
    private final String password;
}
