package user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void create(User user) {
        User exist = userRepository.findByUsername(user.getUsername());
        if (exist != null) {
            throw new EntityExistsException("user with login "
                    + user.getUsername() + " already exists");
        }
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        Set<String> roles = user.getRoles().stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());

        Set<Role> existRoles = roleRepository.findByRoleIn(roles);
        user.setRoles(existRoles);
        existRoles.forEach(role -> role.setUsers(Set.of(user)));
        userRepository.save(user);
    }

    public void addRole(User user, Role role){

    }
}