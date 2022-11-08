package app.someapi.someapiproject.mapper;

import app.someapi.someapiproject.domain.user.UserMain;
import app.someapi.someapiproject.infrastructure.request.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMainMapper {

    UserMainMapper INSTANCE = Mappers.getMapper(UserMainMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "role", target = "role")
    })
    UserMain dtoToEntity(RegistrationRequest registrationRequest);

}
