package domain.payment

trait CreditCardRepository {
  def verify(creditCard: CreditCard): CreditCard
}
