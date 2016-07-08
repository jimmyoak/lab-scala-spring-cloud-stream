package org.jimmyoak.service.reactiveuserservice.api.configuration

import org.jimmyoak.service.reactiveuserservice.core.application.{AddBabyBornBadgeToUserService, CreateUserService, GetUsersService}
import org.jimmyoak.service.reactiveuserservice.core.domain.user.UserRepository
import org.jimmyoak.service.reactiveuserservice.core.domain.user.event.DomainEventPublisher
import org.jimmyoak.service.reactiveuserservice.core.infrastructure.user.InMemoryUserRepository
import org.jimmyoak.service.reactiveuserservice.core.infrastructure.user.event.SpringCloudStreamAllEventsSubscriber
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
@EnableBinding(Array(classOf[UserProducer]))
class UseCaseConfig {
  @Bean
  def createUserService(userRepository: UserRepository, domainEventPublisher: DomainEventPublisher) = {
    CreateUserService(userRepository, domainEventPublisher)
  }

  @Bean
  def getUsersService(userRepository: UserRepository) = GetUsersService(userRepository)

  @Bean
  def addBabyBornBadgeToUserService(userRepository: UserRepository) = AddBabyBornBadgeToUserService(userRepository)

  @Bean
  def userRepository: UserRepository = InMemoryUserRepository()

  @Bean
  def domainEventPublisher(userProducer: UserProducer): DomainEventPublisher = {
    val publisher = DomainEventPublisher()
    publisher.subscribe { SpringCloudStreamAllEventsSubscriber(userProducer.output()) }

    publisher
  }
}
