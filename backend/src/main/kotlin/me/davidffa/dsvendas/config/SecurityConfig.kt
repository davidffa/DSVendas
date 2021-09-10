package me.davidffa.dsvendas.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(
  private val env: Environment
) : WebSecurityConfigurerAdapter() {

  override fun configure(http: HttpSecurity) {
    if (env.activeProfiles.contains("test")) {
      http.headers().frameOptions().disable()
    }

    http.cors().and().csrf().disable()
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    http.authorizeRequests().anyRequest().permitAll()
  }

  @Bean
  fun corsConfigurationSource(): CorsConfigurationSource {
    val configuration = CorsConfiguration().applyPermitDefaultValues().also {
      it.allowedMethods = listOf("POST", "GET", "PUT", "DELETE", "OPTIONS")
    }

    return UrlBasedCorsConfigurationSource().also {
      it.registerCorsConfiguration("/**", configuration)
    }
  }
}