package org.jimmyoak.service.reactiveuserservice.api.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ApplicationConfig {
  @Bean
  def objectMapper() = new ObjectMapper().findAndRegisterModules
}
