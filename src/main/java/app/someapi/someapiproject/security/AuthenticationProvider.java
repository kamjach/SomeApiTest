package app.someapi.someapiproject.security;

import org.springframework.security.core.Authentication;


public interface AuthenticationProvider {

    Authentication getAuthentication();

    String getPrincipal();
}
