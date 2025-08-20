package BookStore.khaiJava.mapper;

import BookStore.khaiJava.dto.request.RoleRequest;
import BookStore.khaiJava.dto.response.RoleResponse;
import BookStore.khaiJava.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest role);
    RoleResponse toRoleResponse(Role role);
}
