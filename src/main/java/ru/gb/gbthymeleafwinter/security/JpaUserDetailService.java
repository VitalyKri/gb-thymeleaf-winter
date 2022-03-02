package ru.gb.gbthymeleafwinter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.gbthymeleafwinter.dao.security.AccountUserDao;
import ru.gb.gbthymeleafwinter.entity.security.AccountUser;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final AccountUserDao accountUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountUser accountUser = accountUserDao.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username:" + username + ". Not found"));

        return accountUser;
    }
}
