package ru.gb.gbthymeleafwinter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // разрешить всем
        http.authorizeRequests((requests) ->
                {
                    requests.antMatchers(HttpMethod.GET, "/product/{productId}").permitAll();
                    requests.antMatchers("/product/all").permitAll();
                    requests.antMatchers("/fail").permitAll();
                    requests.antMatchers(HttpMethod.POST, "/product").hasRole("ADMIN");
                }
        );

        // нарашивает правила
        http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.anyRequest()).authenticated();
        });
        http.formLogin();

    }


    // пароль шифровался
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("$2a$10$8vUZSmBS9/.4r8Sm2fi1.e8zpKMqRtEI8gauUQsGSk9KoBa15pSEW")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("$2a$10$6iCNg492Vz5yFN4Flu9au.xf6OT/lh/2xAHLsnXj3fe5pCRig/p22")
//                .roles("ADMIN");
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    // бин позволяющий авторизовываться, пользователь как объект в java
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        // шаблон ролей
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//        // мап, которая отдается спрингу
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}


