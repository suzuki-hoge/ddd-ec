package domain.payment

import org.scalatest.FunSuite

class PaymentServiceTest extends FunSuite {
  test("right for credit card") {
    val in = RequestedPayment(Some(CreditCard("123")), PayWithCreditCard)
    val out = ValidatedPayment(Some(CreditCard("123")), PayWithCreditCard)
    assert(PaymentService.verify(in) == Right(out))
  }
  test("left for else") {
    val in = RequestedPayment(None, PayWithCreditCard)
    assert(PaymentService.verify(in) == Left("invalid payment"))
  }
}
