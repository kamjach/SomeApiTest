package app.someapi.someapiproject.repository;

import app.someapi.someapiproject.domain.user.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

    ConfirmationToken findByToken(String token);

}
