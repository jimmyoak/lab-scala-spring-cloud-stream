package org.jimmyoak.service.reactiveuserservice.core.domain.user

import java.time.ZonedDateTime
import java.util.UUID

import scala.collection.mutable

import org.jimmyoak.service.reactiveuserservice.core.domain.badge.Badge

case class UserId(value: String) {
  type InvalidUserId = IllegalArgumentException
  try {
    UUID.fromString(value)
  } catch {
    case exception: IllegalArgumentException => throw new InvalidUserId
  }

  def this() = this(UUID.randomUUID().toString)
}

case class User(id: UserId, nickname: String, name: String, email: String, creationDate: ZonedDateTime) {
  val badges: mutable.MutableList[Badge] = mutable.MutableList()

  def this(nickname: String, name: String, email: String) = {
    this(new UserId, nickname, name, email, ZonedDateTime.now)
  }
}
