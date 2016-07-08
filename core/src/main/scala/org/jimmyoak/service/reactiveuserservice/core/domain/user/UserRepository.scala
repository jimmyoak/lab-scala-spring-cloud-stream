package org.jimmyoak.service.reactiveuserservice.core.domain.user

trait UserRepository {
  def findBy(id: UserId): User

  def findAll: List[User]

  def persist(user: User): User
}
