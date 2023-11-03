package g56514.webg5.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        //Pour créer des utilisateurs.
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "select username, password, enabled from users where username=?"
            )
            .authoritiesByUsernameQuery(
                "select username, authority from authority where username=?"
            );

            //Pour checker les utilisateurs
            //surtout utile et obligé pour checker les utilisateurs créer depuis data.sql.
            //car le code au-dessus créé et check les utilisateurs créés, mais pour les utilisateurs créés depuis data.sql, ça checkera pas, donc il faut le code ci-dessous.
            auth.jdbcAuthentication()
            .dataSource(dataSource).withDefaultSchema()
            .passwordEncoder(pwdEncoder)
            .withUser(
                User.withUsername("user")
                    .password(pwdEncoder.encode("passwd"))
                    .authorities("USER")
            );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                // la ligne en dessous de celle juste en dessous(ligne 29) permet de dire que si
                // on tente de se rendre à l'url /private, on sera rediriger vers le formulaire
                // de login.
                .antMatchers("/private").hasAuthority("PROF")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/")
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
