package api.book.purchase.form

import domain.account.UserId

case object UserIdForm {
  def bind(value: String): UserId = UserId(value)
}
