package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.UserRequest;
import BookStore.khaiJava.dto.response.RoleResponse;
import BookStore.khaiJava.dto.response.UserResponse;
import BookStore.khaiJava.entity.Role;
import BookStore.khaiJava.entity.User;
import BookStore.khaiJava.exception.AppException;
import BookStore.khaiJava.exception.ErrorCode;
import BookStore.khaiJava.mapper.RoleMapper;
import BookStore.khaiJava.mapper.UserMapper;
import BookStore.khaiJava.repository.RoleRepository;
import BookStore.khaiJava.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    RoleMapper roleMapper;

    public UserResponse addUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + userRequest.getRoleId()));
        roles.add(role);

        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

    public UserResponse updateUser(int userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        userMapper.toMapper(user, userRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getUser(int userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse u = userMapper.toUserResponse(user);
            Set<RoleResponse> setRoles = new HashSet<>();
            for (Role role : user.getRoles()) {
                setRoles.add(roleMapper.toRoleResponse(role));
            }
            u.setRoles(setRoles);
            userResponses.add(u);
        }
        return userResponses;
    }



}
