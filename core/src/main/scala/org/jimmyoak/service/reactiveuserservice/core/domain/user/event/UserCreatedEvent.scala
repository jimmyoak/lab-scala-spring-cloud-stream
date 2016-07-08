package org.jimmyoak.service.reactiveuserservice.core.domain.user.event

import scala.beans.BeanProperty

case class UserCreatedEvent(@BeanProperty userId: String) extends DomainEvent("usercreated")
