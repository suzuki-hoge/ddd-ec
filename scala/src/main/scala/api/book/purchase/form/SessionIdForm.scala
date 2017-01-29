package api.book.purchase.form

import domain.account.SessionId

case object SessionIdForm {
  def bind(value: String): SessionId = SessionId(value)
}
