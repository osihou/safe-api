package com.projectpl.safeapi.config;
import com.projectpl.safeapi.service.user.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/login*", "/logout*", "/signin/**", "/signup/**", "/customLogin","/test_mail","/pdf_report",
                            "/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
                        "/badUser*", "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*","/user/savePassword*","/updatePassword*",
                        "/user/changePassword*", "/emailError*", "/resources/**","/old/user/registration*","/successRegister*","/qrcode*","/user/enableNewLoc*").permitAll()
                    .antMatchers("/invalidSession*").anonymous()
                    .antMatchers("/user/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
                    .anyRequest().hasAuthority("READ_PRIVILEGE")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/homepage.html")
                    .failureUrl("/login?error=true")
                   // .successHandler(customLoginAuthenticationSuccessHandler)
                    //.failureHandler(customAuthenticationFailureHandler)
                    //.authenticationDetailsSource(authenticationDetailsSource)
                .permitAll()
                    .and()
                .sessionManagement()
                    .invalidSessionUrl("/invalidSession.html")
                    //.maximumSessions(1).sessionRegistry(sessionRegistry()).and()
                    //.sessionFixation().none()
                .and()
                    .logout()
                    //.logoutSuccessHandler(myLogoutSuccessHandler)
                    .invalidateHttpSession(false)
                    //.logoutSuccessUrl("/logout.html?logSucc=true")
                    //.deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                    //.rememberMe().rememberMeServices(rememberMeServices()).key("theKey")
                    //.and()
                .headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }


}
