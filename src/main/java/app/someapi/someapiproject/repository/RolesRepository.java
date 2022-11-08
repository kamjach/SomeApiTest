package app.someapi.someapiproject.repository;

import app.someapi.someapiproject.domain.user.Role;
import java.util.List;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Role, Integer> {

    Set<Role> findRolesByNameIn(List<String> name);

}
