package org.jimmyoak.service.reactiveuserservice.core.infrastructure.user

import org.jimmyoak.service.reactiveuserservice.core.domain.user.{User, UserId, UserRepository}

import scala.collection.mutable

case class InMemoryUserRepository() extends UserRepository {
  private val users: mutable.MutableList[User] = mutable.MutableList()

  override def findBy(userId: UserId) = {
    users.filter(_.id == userId).last
  }

  override def findAll: List[User] = users.toList

  override def persist(user: User) = {
    users += user

    user
  }
}
