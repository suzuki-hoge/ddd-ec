package service.local

import datasource.payment.{ConvenienceStorePaymentRepositoryDb, CreditCaredRepositoryDb}
import domain.payment._

case object PurchaseService {
  val creditCardRepository: CreditCardRepository = CreditCaredRepositoryDb
  val convenienceStorePaymentRepository: ConvenienceStorePaymentRepository = ConvenienceStorePaymentRepositoryDb

  def apply(validatedPayment: ValidatedPayment, amount: Amount): Option[ConvenienceStorePaymentCode] = validatedPayment.paymentType match {
    case PayWithCreditCard =>
      creditCardRepository.verify(validatedPayment.creditCard.get)
      None
    case AtConvenienceStore => Some(convenienceStorePaymentRepository.apply(amount))
    case AtReceived => None
  }
}
