package app.someapi.someapiproject.repository;

import app.someapi.someapiproject.domain.user.UserMain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserMain, String> {

    UserMain findTopByEmail(String email);

    UserMain findByEmail(String email);
}
