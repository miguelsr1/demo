package sv.gob.bandesal.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user1").password("{noop}user1Pass").roles("USER");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		 http.authorizeRequests()
	      .antMatchers("/api/*").authenticated()
	      .antMatchers("/app/*").authenticated()
	      .antMatchers("/login*").permitAll()
	      .and().httpBasic()
	      .and().formLogin(form -> form
	    		  .defaultSuccessUrl("/app/blogs")
	    		  .loginPage("/login")
	    		  .failureUrl("/login?error=true"));
	}
	
}
