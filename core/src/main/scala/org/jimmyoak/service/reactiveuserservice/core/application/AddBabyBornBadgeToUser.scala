package org.jimmyoak.service.reactiveuserservice.core.application

import org.jimmyoak.service.reactiveuserservice.core.domain.badge.BabyBornBadge
import org.jimmyoak.service.reactiveuserservice.core.domain.user.{UserId, UserRepository}

case class AddBabyBornBadgeToUserRequest(userId: String)

case class AddBabyBornBadgeToUserResponse(userId: String, badgeId: String)

case class AddBabyBornBadgeToUserService(userRepository: UserRepository) {
  def execute(request: AddBabyBornBadgeToUserRequest) = {
    val user = userRepository.findBy(UserId(request.userId))

    val badge = BabyBornBadge()

    user.badges += badge

    AddBabyBornBadgeToUserResponse(user.id.value, badge.id.value)
  }
}
