package domain.payment


object PaymentService {
  def verify(requestedPayment: RequestedPayment): Either[String, ValidatedPayment] = requestedPayment match {
    case RequestedPayment(Some(x: CreditCard), y) => Right(ValidatedPayment(Some(x), y))
    case RequestedPayment(None, PayWithCreditCard) => Left("invalid payment")
    case RequestedPayment(x, y) => Right(ValidatedPayment(x, y))
  }
}
