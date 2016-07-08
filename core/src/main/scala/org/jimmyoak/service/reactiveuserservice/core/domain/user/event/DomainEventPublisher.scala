package org.jimmyoak.service.reactiveuserservice.core.domain.user.event

import scala.collection.mutable

case class DomainEventPublisher() {
  private val subscribers: mutable.MutableList[DomainEventSubscriber] = mutable.MutableList()

  def subscribe(subscriber: DomainEventSubscriber) = subscribers += subscriber

  def publish(event: DomainEvent) {
    subscribers
        .filter(_.isSubscribedTo(event))
        .foreach(_.handle(event))
  }
}

