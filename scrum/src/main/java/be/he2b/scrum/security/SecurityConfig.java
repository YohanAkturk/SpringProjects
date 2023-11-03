package be.he2b.scrum.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String secret1 = encoder.encode("bob");
        UserDetails user1 = User.withUsername("bob")
                .password(secret1)
                .roles("ADMIN")
                .build();

        String secret2 = encoder.encode("alice");
        UserDetails user2 = User.withUsername("alice")
                .password(secret2)
                .roles("USER")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        users.setUsersByUsernameQuery("select username, password, enabled from users where username = ?");
        users.setAuthoritiesByUsernameQuery("select username, authority from authorities where username = ?");

        users.createUser(user1);
        users.createUser(user2);

        return users;
    }

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

		http
			.authorizeHttpRequests((requests) -> requests
                //si je veux restreindre l'accès à des pages pour ceux qui sont pas authentifiés,
                //faire la ligne ci-dessous et mettre ds les paramètres de la méthode requestMatchers, par exemple : requestMatchers("/uneUrlRestreinte", "uneAutreUrlRestreinte")
                // .requestMatchers("/h2-console/**", "/", "/images").authenticated()
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.permitAll()
			)
            //si je termine par permitAll() pour la ligne ci-dessous, ça redirigera vers le login qd je me serai logout.
			.logout((logout) -> logout.permitAll().logoutSuccessHandler((request, response, authentication) -> {
                response.sendRedirect("/");
            }));

		return http.build();
	}

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
    //     http.csrf().disable();
    //     http.headers().frameOptions().disable();
    // }

}