package org.jimmyoak.service.reactiveuserservice.core.application

import org.jimmyoak.service.reactiveuserservice.core.domain.user.{User, UserRepository}

case class GetUsersRequest()

case class GetUsersResponse(users: List[User])

case class GetUsersService(userRepository: UserRepository) {
  def execute(request: GetUsersRequest) = {
    userRepository.findAll
  }
}

