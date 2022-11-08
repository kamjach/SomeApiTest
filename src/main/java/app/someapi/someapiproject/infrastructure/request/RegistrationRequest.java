package app.someapi.someapiproject.infrastructure.request;

import app.someapi.someapiproject.domain.user.Role;
import java.util.Set;
import lombok.Data;

@Data
public class RegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final boolean enabled;
    private Set<Role> role;

}
