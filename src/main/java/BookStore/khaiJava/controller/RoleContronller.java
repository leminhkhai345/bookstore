package BookStore.khaiJava.controller;


import BookStore.khaiJava.dto.request.RoleRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.dto.response.RoleResponse;
import BookStore.khaiJava.service.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping ("/role")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class RoleContronller {
    RoleService roleService;

    @PostMapping("/")
    public ApiResponse<RoleResponse> createRole(@RequestBody @Valid RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .message("create role successfully!")
                .data(roleService.createRole(request))
                .build();
    }

    @DeleteMapping("/{roleId}")
    public ApiResponse<Void> deleteRole(@PathVariable int roleId){
        roleService.deleteRole(roleId);
        return ApiResponse.<Void>builder()
                .message("deleted role successfully!")
                .build();
    }

    @PostMapping("/{roleId}")
    public ApiResponse<RoleResponse> updateRole(@PathVariable int roleId, @RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .message("update role successfully")
                .data(roleService.updateRole(roleId, request))
                .build();

    }

    @GetMapping("/{roleId}")
    public ApiResponse<?> getRole(@PathVariable int roleId){
        return ApiResponse.builder()
                .message("get role id = " + roleId)
                .data(roleService.getRole(roleId))
                .build();
    }

    @GetMapping("/")
    public ApiResponse<?> getAllRoles(){
        return ApiResponse.builder()
                .message("get all roles")
                .data(roleService.getAllRole())
                .build();
    }
}

