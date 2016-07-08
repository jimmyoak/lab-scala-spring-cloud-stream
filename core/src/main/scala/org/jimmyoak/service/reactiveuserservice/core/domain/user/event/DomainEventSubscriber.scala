package org.jimmyoak.service.reactiveuserservice.core.domain.user.event

trait DomainEventSubscriber {
  def isSubscribedTo(event: DomainEvent): Boolean

  def handle(event: DomainEvent): Unit
}
