package domain.payment

case class RequestedPayment(creditCard: Option[CreditCard], paymentType: PaymentType)
