package za.ac.uct.security;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter ;
    private final CustomerUserDetailsService customerUserDetailsService ;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    { http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests()

            //user endpoints
            //user registration endpoints
            .requestMatchers("/api/user/register").permitAll()
            .requestMatchers("/api/user/authenticate").permitAll()
            .requestMatchers("/api/user/profile/*").hasAuthority("USER")
            .requestMatchers("/api/user/RSVPs/*").hasAuthority("USER")

            //user about and contact us endpoints
            .requestMatchers("/api/aboutUs/read/*").permitAll()
            .requestMatchers("/api/contactUs/create").permitAll()

            //user settings endpoints
            .requestMatchers("/api/settings/read").permitAll()

            //user event endpoints
            .requestMatchers("/api/events/**").permitAll()

            //help center and faq user endpoints
            .requestMatchers("/api/faq/**").permitAll()
            .requestMatchers("/api/help-center/**").permitAll()


            //admin endpoints
            .requestMatchers("/api/admin/**").hasAuthority("ADMIN")

            //admins testing
            .requestMatchers("/api/admins/**").hasAuthority("ADMIN");

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return  http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();}

    @Bean
    public PasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder(); }

}
