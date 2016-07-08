package org.jimmyoak.service.reactiveuserservice.api.controller

import org.jimmyoak.service.reactiveuserservice.core.application._
import org.springframework.web.bind.annotation._

@RestController
class UserController(createUserService: CreateUserService, getUsersService: GetUsersService) {
  @RequestMapping(path = Array("/users"), method = Array(RequestMethod.POST))
  def createUser(@RequestBody request: CreateUserRequest) = {
    createUserService.execute(request)
  }

  @RequestMapping(path = Array("/users"), method = Array(RequestMethod.GET))
  def getUser() = {
    getUsersService.execute(GetUsersRequest())
  }
}
