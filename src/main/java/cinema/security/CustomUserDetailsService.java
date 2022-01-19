package cinema.security;

import cinema.model.User;
import cinema.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User with email " + username + " not found"));
        UserBuilder builder
                = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream()
                .map(r -> r.getRoleName().name()).toArray(String[]::new));
        return builder.build();
    }
}
