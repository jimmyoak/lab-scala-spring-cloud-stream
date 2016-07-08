package org.jimmyoak.service.reactiveuserservice.core.application

import java.time.ZonedDateTime

import org.jimmyoak.service.reactiveuserservice.core.domain.user.event.{DomainEventPublisher, UserCreatedEvent}
import org.jimmyoak.service.reactiveuserservice.core.domain.user.{User, UserRepository}

import scala.beans.BeanProperty

case class CreateUserRequest(nickname: String, name: String, email: String)

case class CreateUserResponse(@BeanProperty id: String, @BeanProperty nickname: String, @BeanProperty name: String, @BeanProperty email: String, @BeanProperty creationDate: ZonedDateTime)

case class CreateUserService(userRepository: UserRepository, domainEventPublisher: DomainEventPublisher) {
  def execute(request: CreateUserRequest) = {
    val user: User = userRepository.persist(new User(request.nickname, request.name, request.email))

    domainEventPublisher.publish(UserCreatedEvent(user.id.value))

    CreateUserResponse(user.id.value, user.nickname, user.name, user.email, user.creationDate)
  }
}
