package org.jimmyoak.service.reactiveuserservice.core.domain.badge

import java.util.UUID

case class BadgeId(value: String) {
  type InvalidBadgeId = IllegalArgumentException
  try {
    UUID.fromString(value)
  } catch {
    case exception: IllegalArgumentException => throw new InvalidBadgeId
  }

  def this() = this(UUID.randomUUID().toString)
}

abstract class Badge(val id: BadgeId, val name: String)

case class BabyBornBadge() extends Badge(new BadgeId(), "Baby Born")
