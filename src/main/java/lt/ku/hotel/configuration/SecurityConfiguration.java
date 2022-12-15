package lt.ku.hotel.configuration;

import lt.ku.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	UserService clientService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
		auth
				.userDetailsService(this.clientService)
				.passwordEncoder(bc);
	}
	protected void configure(HttpSecurity http) throws Exception {
		
		http
				.authorizeRequests()
				.antMatchers("/admin").permitAll()//.hasAuthority("admin")//// TURN ON AUTHORITIES
				.antMatchers("/update_users/*").permitAll()
				.antMatchers("/games/*").permitAll()//.hasAuthority("admin")
				.antMatchers("/games/").permitAll()//.hasAuthority("admin")
				.antMatchers("/games/new").permitAll()//.hasAuthority("admin")
				.antMatchers("/update/*").permitAll()
				.antMatchers("/update").permitAll()
				.antMatchers("/update/").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/login*").permitAll()
				.antMatchers("/register*").permitAll()
				.antMatchers("/rooms*").permitAll()
				.antMatchers("/reserve*").permitAll()
				.antMatchers("/reservations*").permitAll()
				.anyRequest().authenticated() // hasAuthority("user")

				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("email").permitAll()
				.defaultSuccessUrl("/")
				.failureUrl("/login-error")
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
