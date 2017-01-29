package datasource.payment

import domain.payment.{CreditCard, CreditCardRepository}

case object CreditCaredRepositoryDb extends CreditCardRepository {
  def verify(creditCard: CreditCard): CreditCard = creditCard.value match {
    case "visa-1" => creditCard
    case _ => throw new RuntimeException("invalid credit card")
  }
}
