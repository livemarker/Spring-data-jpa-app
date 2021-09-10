package task30.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import task30.DAO.repositories.UserDAORepository;
import task30.entity.User;


import java.util.Collection;
import java.util.Collections;

@Component
public class UserService implements UserDetailsService, UserServiceInterface {
    private UserDAORepository userDAORepository;

    @Autowired
    public UserService(UserDAORepository userDAORepository) {
        this.userDAORepository = userDAORepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAORepository.getByLogin(username);

        return new UserSecurity(user.getLogin(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    public String getSecurityLogin() {
        UserDetails principal = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return principal.getUsername();
    }
}