package org.jimmyoak.service.reactiveuserservice.api.configuration

import org.jimmyoak.service.reactiveuserservice.api.controller.UserController
import org.jimmyoak.service.reactiveuserservice.core.application.{CreateUserService, GetUsersService}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ControllerConfig {
  @Bean
  def userController(
                        createUserService: CreateUserService,
                        getUsersService: GetUsersService
                    ) = new UserController(createUserService, getUsersService)
}
