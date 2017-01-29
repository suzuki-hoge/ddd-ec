package domain.payment

case class ValidatedPayment(creditCard: Option[CreditCard], paymentType: PaymentType)
