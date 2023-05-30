package pe.edu.cibertec.dawii_cl1_pierre_lino.configuracion;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.cibertec.dawii_cl1_pierre_lino.service.UsuarioDetalleService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final UsuarioDetalleService usuarioDetalleService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                .requestMatchers("/auth/login",
                        "/auth/registrar",
                        "/auth/guardarAlumno",
                        "/resource/**",
                        "/static/**",
                        "/styles/**",
                        "/scripts/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("nomusuario")
                .passwordParameter("passusuario")
                .and()
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //authenticationProvider.setUserDetailsService(usuarioDetalleService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }
}
