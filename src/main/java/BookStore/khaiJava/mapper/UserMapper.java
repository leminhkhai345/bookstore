package BookStore.khaiJava.mapper;

import BookStore.khaiJava.dto.request.UserRequest;
import BookStore.khaiJava.dto.response.UserResponse;
import BookStore.khaiJava.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
    void toMapper(@MappingTarget User user , UserRequest userRequest);
}
