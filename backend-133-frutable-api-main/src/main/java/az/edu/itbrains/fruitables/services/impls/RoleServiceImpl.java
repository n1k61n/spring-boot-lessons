package az.edu.itbrains.fruitables.services.impls;


import az.edu.itbrains.fruitables.models.Role;
import az.edu.itbrains.fruitables.repositories.RoleRepository;
import az.edu.itbrains.fruitables.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String roleName) {
        Role role =roleRepository.findByName(roleName).orElseThrow();
        return role;
    }
}