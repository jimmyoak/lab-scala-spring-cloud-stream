package org.jimmyoak.service.reactiveuserservice.api.event.consumer

import com.fasterxml.jackson.annotation.JsonProperty
import org.jimmyoak.service.reactiveuserservice.api.configuration.UserProducer
import org.jimmyoak.service.reactiveuserservice.core.application.{AddBabyBornBadgeToUserRequest, AddBabyBornBadgeToUserService}
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.{EnableBinding, StreamListener}
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.{Header, Payload}

case class UserEventMessage(@JsonProperty("userId") userId: String)

@EnableBinding(Array(classOf[UserProducer]))
class UserEventConsumer(addBabyBornBadgeToUserService: AddBabyBornBadgeToUserService) {
  private val logger = LoggerFactory.getLogger(classOf[Application])

  @StreamListener("user-channel")
  def dispatchEvent(@Header(MessageHeaders.CONTENT_TYPE) contentType: String, @Payload payload: UserEventMessage): Unit = {
    logger.info(payload.userId)
    addBabyBornBadgeToUserService.execute(AddBabyBornBadgeToUserRequest(payload.userId))
  }
}
