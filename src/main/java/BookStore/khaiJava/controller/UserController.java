package BookStore.khaiJava.controller;

import BookStore.khaiJava.dto.request.UserRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.dto.response.UserResponse;
import BookStore.khaiJava.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("/")
    public ApiResponse<UserResponse> createUSer(@RequestBody @Valid UserRequest user){
        return ApiResponse.<UserResponse>builder()
                .message("created user successfully")
                .data(userService.addUser(user))
                .build();
    }

    @PostMapping("/{userId}")
    public ApiResponse<?> updateUser(@PathVariable int userId, @RequestBody @Valid UserRequest user){
        return ApiResponse.builder()
                .message("updated user successfully")
                .data(userService.updateUser(userId, user))
                .build();
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<?> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return ApiResponse.builder()
                .message("delete user successfully")
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<?> getUser(@PathVariable int userId){
        return ApiResponse.builder()
                .message("get user id = " + userId)
                .data(userService.getUser(userId))
                .build();
    }

    @GetMapping("/")
    public ApiResponse<?> getAllUsers(){
        return ApiResponse.builder()
                .message("get all users")
                .data(userService.getAllUser())
                .build();
    }
}
