package g56514.webg5.pae.security;

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
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication()
        .dataSource(dataSource).withDefaultSchema()
        .passwordEncoder(pwdEncoder)
        .withUser(
            User.withUsername("mcd")
                .password(pwdEncoder.encode("mcd"))
                .authorities("PROF")
        ).withUser(
            User.withUsername("jlc")
            .password(pwdEncoder.encode("jlc"))
            .authorities("PROF")
        ).withUser(
            User.withUsername("secrétaire")
                .password(pwdEncoder.encode("secrétaire"))
                .authorities("SECRETAIRE")
        ).withUser(
            User.withUsername("testStudent")
                .password(pwdEncoder.encode("testStudent"))
                .authorities("ETUDIANT")
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        //ça a servi qd h2 me laissait pas me connecter genre qd ça se connectait mais que ça mettait une page error forbidden.
        //Les 2 lignes ci-dessous font fonctionner l'accès.
        //MAIS ATTENTION : utiliser ces 2 lignes que pour le débuggage ! PAS REMETTRE LE PROJET AVEC CES 2 LIGNES !
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
            // la ligne en dessous de celle juste en dessous(ligne 29) permet de dire que si on tente de se rendre à l'url /private, on sera rediriger vers le formulaire de login.
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
