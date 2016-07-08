package org.jimmyoak.service.reactiveuserservice.core.domain.user.event

import java.time.ZonedDateTime

import scala.beans.BeanProperty

abstract class DomainEvent(@BeanProperty eventName: String, @BeanProperty occurredOn: ZonedDateTime) {
  def this(eventName: String) = this(eventName, ZonedDateTime.now)
}
