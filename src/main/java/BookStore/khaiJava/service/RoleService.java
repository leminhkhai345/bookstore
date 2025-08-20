package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.RoleRequest;
import BookStore.khaiJava.dto.response.RoleResponse;
import BookStore.khaiJava.entity.Role;
import BookStore.khaiJava.mapper.RoleMapper;
import BookStore.khaiJava.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest roleRequest){
        Role role = roleMapper.toRole(roleRequest);
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public void deleteRole(int roleId){
        roleRepository.deleteById(roleId);
    }

    public RoleResponse updateRole(int roleId, RoleRequest roleRequest){
        Role role = roleRepository.findById(roleId).orElse(null);
        if(role != null){
            role.setRoleName(roleRequest.getRoleName());
            role.setDescription(roleRequest.getDescription());
        }
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public RoleResponse getRole(int roleId){
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("role " + roleId + "not existed"));
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAllRole(){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }
}
