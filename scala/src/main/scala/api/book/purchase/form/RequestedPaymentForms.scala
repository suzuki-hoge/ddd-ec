package api.book.purchase.form

import domain.payment._

case object RequestedPaymentForms {
  def bind(creditCard: String, paymentType: String): RequestedPayment = {
    RequestedPayment(
      CreditCardForm.bind(creditCard),
      PaymentTypeForm.bind(paymentType)
    )
  }
}

case object CreditCardForm {
  def bind(value: String): Option[CreditCard] = value match {
    case "" => None
    case x => Some(CreditCard(x))
  }
}

case object PaymentTypeForm {
  def bind(value: String): PaymentType = value match {
    case "PayWithCreditCard" => PayWithCreditCard
    case "AtConvenienceStore" => AtConvenienceStore
    case "AtReceived" => AtReceived
  }
}
