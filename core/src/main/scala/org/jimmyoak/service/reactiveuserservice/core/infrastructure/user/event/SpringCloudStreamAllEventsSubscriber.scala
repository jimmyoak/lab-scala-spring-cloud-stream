package org.jimmyoak.service.reactiveuserservice.core.infrastructure.user.event

import org.jimmyoak.service.reactiveuserservice.core.domain.user.event.{DomainEvent, DomainEventSubscriber}
import org.springframework.messaging.support.MessageBuilder
import org.springframework.messaging.{Message, MessageChannel, MessageHeaders}

case class SpringCloudStreamAllEventsSubscriber(outputChannel: MessageChannel) extends DomainEventSubscriber {
  override def isSubscribedTo(event: DomainEvent) = true

  override def handle(event: DomainEvent): Unit = {
    val boobs: Message[DomainEvent] = MessageBuilder
        .withPayload(event)
        .setHeader(MessageHeaders.CONTENT_TYPE, createEventName(event))
        .build()
    outputChannel.send(boobs)
  }

  private def createEventName(event: DomainEvent) = "application/json; event=" + event.getClass.getSimpleName.trim.toLowerCase
}
