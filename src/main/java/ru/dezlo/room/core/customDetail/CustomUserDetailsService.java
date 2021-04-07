package ru.dezlo.room.core.customDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.dezlo.room.core.models.ModelUser;
import ru.dezlo.room.core.servicesImpl.ServiceUserImpl;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ServiceUserImpl serviceUserImpl;

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ModelUser modelUser = serviceUserImpl.findByNicknameOrEmail(email);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(modelUser);
    }
}