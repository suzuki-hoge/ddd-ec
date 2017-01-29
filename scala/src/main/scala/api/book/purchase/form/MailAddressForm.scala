package api.book.purchase.form

import domain.account.MailAddress

case object MailAddressForm {
  def bind(value: String): MailAddress = MailAddress(value)
}
