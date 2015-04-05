package freeplace.lla.model.authorization;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import freeplace.lla.model.data.service.user.UserServiceImpl;
import freeplace.lla.model.entities.user.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import freeplace.lla.model.entities.user.User;
 
public class UserAuthorizationService implements UserDetailsService {
 
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        try {
            user = new UserServiceImpl().findByLogin(login, false);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
        } catch (UsernameNotFoundException e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        }
        String password = user.getPassword();
        UserAccount userAccount = user.getUserAccount();
        boolean enabled = userAccount.getIsEnabled();
        boolean accountNonExpired = !userAccount.getIsExpired();
        boolean credentialsNonExpired = !userAccount.getIsExpiredCredentials();
        boolean accountNonLocked = !userAccount.getIsLocked();
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(
                login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}