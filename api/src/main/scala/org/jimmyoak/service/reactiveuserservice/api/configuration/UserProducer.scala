package org.jimmyoak.service.reactiveuserservice.api.configuration

import org.springframework.cloud.stream.annotation.{EnableBinding, Output}
import org.springframework.messaging.MessageChannel

@EnableBinding
trait UserProducer {
  @Output("user-channel")
  def output(): MessageChannel
}
