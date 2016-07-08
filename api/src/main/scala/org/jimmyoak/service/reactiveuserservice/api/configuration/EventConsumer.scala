package org.jimmyoak.service.reactiveuserservice.api.configuration

import org.jimmyoak.service.reactiveuserservice.api.event.consumer.UserEventConsumer
import org.jimmyoak.service.reactiveuserservice.core.application.AddBabyBornBadgeToUserService
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class EventConsumer {
  @Bean
  def userEventConsumer(addBabyBornBadgeToUserService: AddBabyBornBadgeToUserService) = new UserEventConsumer(addBabyBornBadgeToUserService)
}
